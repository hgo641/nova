package org.example.nova.robot.service;

import org.example.nova.robot.domain.ElevatorDoorStatus;
import org.example.nova.robot.domain.ElevatorStatus;
import org.example.nova.robot.dto.ElevatorStatusGetRequest;
import org.example.nova.robot.dto.ElevatorStatusResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.SocketTimeoutException;
import java.time.Duration;

@Service
public class RobotService {

    private final RestTemplate restTemplate;

    // TODO restTemplate을 사용해 아파트 단지 서버에 요청을 보내주세요!
    public RobotService(RestTemplateBuilder builder) {
        this.restTemplate = builder
                .setConnectTimeout(Duration.ofSeconds(2))  // 연결 타임아웃 2초
                .setReadTimeout(Duration.ofSeconds(5))     // 읽기 타임아웃 5초
                .build();
    }

    public ElevatorStatusResponse getElevatorStatus(ElevatorStatusGetRequest request) {
        String apartmentServerUrl = getApartmentServerUrl(request.getApartmentId());
        if (apartmentServerUrl == null) {
            throw new IllegalArgumentException("지원하지 않는 아파트 입니다. 아파트 ID: " + request.getApartmentId());
        }

        // 최종 요청 URL 구성
        String url = String.format("%s/elevator/%s/%s", apartmentServerUrl, request.getDong(), request.getHogi());

        ElevatorStatusResponse elevatorStatusResponseFromApartmentServer = getElevatorStatusResponseFromApartmentServer(url);

        ElevatorStatus elevatorStatus = ElevatorStatus.fromCode(elevatorStatusResponseFromApartmentServer.getElevatorStatus());
        ElevatorDoorStatus elevatorDoorStatus = ElevatorDoorStatus.valueOf(elevatorStatusResponseFromApartmentServer.getDoorStatus());

        return new ElevatorStatusResponse(
                elevatorStatus.getMessage(),
                elevatorDoorStatus.getMessage(),
                elevatorStatusResponseFromApartmentServer.getCurrentFloor()
        );
    }

    private ElevatorStatusResponse getElevatorStatusResponseFromApartmentServer(String url) {
        try {
            ResponseEntity<ElevatorStatusResponse> response =
                    restTemplate.getForEntity(url, ElevatorStatusResponse.class);

            return response.getBody();
        } catch (ResourceAccessException e) {
            // RestTemplate 내부에서 I/O 예외 → ResourceAccessException 으로 감쌉니다.
            if (e.getCause() instanceof SocketTimeoutException) {
                throw new RuntimeException("아파트 단지서버에 엘리베이터 상태 조회를 요청하던 중 ReadTimeout이 발생했습니다.", e);
            }

            // SocketTimeoutException이 아닐 경우에는 아래의 catch문으로 넘깁니다.
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException("아파트 단지서버로 엘리베이터 상태 조회를 요청했으나 실패했습니다.", e);
        }
    }

    // TODO 아래 메서드를 사용해 적절한 아파트 단지서버에 HTTP 요청을 보내주세요.
    private String getApartmentServerUrl(String apartmentId) {
        if (apartmentId.equals("1")) {
            return "http://localhost:8080/apartment/good";
        }

        if (apartmentId.equals("2")) {
            return "http://localhost:8080/apartment/bad";
        }

        return null;
    }
}
