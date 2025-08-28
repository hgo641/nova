package org.example.nova.bus.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.nova.bus.dto.BusArrivalRequest;
import org.example.nova.bus.dto.BusArrivalResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class GyeongGiBusService implements BusService {

    private static final String BUS_ARRIVAL_URL = "https://apis.data.go.kr/6410000/busarrivalservice/v2/getBusArrivalItemv2";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    private static final Logger log = LoggerFactory.getLogger(GyeongGiBusService.class);

    @Value("${open-api.bus.service-key}")
    private String SERVICE_KEY_ENCODED;

    @Override
    public BusArrivalResponse getBusArrival(BusArrivalRequest req) {
        URI uri = UriComponentsBuilder.fromHttpUrl(BUS_ARRIVAL_URL)
                .queryParam("serviceKey", SERVICE_KEY_ENCODED)
                .queryParam("stationId", req.getStationId())
                .queryParam("routeId",   req.getRouteId())
                .queryParam("staOrder",  req.getStaOrder())
                .queryParam("format",    "json")
                .build(true) // 추가 인코딩 하지 않음
                .toUri();

        String json = REST_TEMPLATE.getForObject(uri, String.class);

        try {
            JsonNode item = OBJECT_MAPPER.readTree(json).path("response").path("msgBody").path("busArrivalItem");

            int firstBusRemainingTimeSecond = item.path("predictTimeSec1").asInt(-1);
            int secondBusRemainingTimeSecond = item.path("predictTimeSec2").asInt(-1);

            String firstBusRemainingTimeMessage = getRemainingTimeMessageByTotalSeconds(firstBusRemainingTimeSecond); // 예: 183 -> "3분 3초"
            String secondBusRemainingTimeMessage = getRemainingTimeMessageByTotalSeconds(secondBusRemainingTimeSecond); // 예: 1596 -> "26분 36초"

            return new BusArrivalResponse(firstBusRemainingTimeMessage, secondBusRemainingTimeMessage);

        } catch (Exception e) {
            log.error("버스 도착 정보 파싱 중 에러가 발생했습니다. 에러 : {}, json : {}", e, json);
            throw new IllegalStateException("버스 도착 정보 파싱에 실패했습니다.");
        }
    }

    /**
     * 초 → "X분 Y초" 메시지로 변환
     */
    private String getRemainingTimeMessageByTotalSeconds(int totalSeconds) {
        if (totalSeconds < 0) {
            return "예정 정보 없음";
        }
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        if (minutes == 0) {
            return seconds + "초";
        }
        if (seconds == 0) {
            return minutes + "분";
        }
        return minutes + "분 " + seconds + "초";
    }
}
