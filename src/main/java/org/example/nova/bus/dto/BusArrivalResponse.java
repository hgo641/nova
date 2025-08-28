package org.example.nova.bus.dto;

public class BusArrivalResponse {

    private String firstBusRemainingTimeMessage; // "1분 2초" 형태의 메시지 출력
    private String secondBusRemainingTimeMessage;

    public BusArrivalResponse(String firstBusRemainingTimeMessage, String secondBusRemainingTimeMessage) {
        this.firstBusRemainingTimeMessage = firstBusRemainingTimeMessage;
        this.secondBusRemainingTimeMessage = secondBusRemainingTimeMessage;
    }

    public String getFirstBusRemainingTimeMessage() {
        return firstBusRemainingTimeMessage;
    }

    public String getSecondBusRemainingTimeMessage() {
        return secondBusRemainingTimeMessage;
    }
}
