package org.example.nova.apartment.domain;

public enum ElevatorStatus {
    NORMAL("00"), // 정상운행
    FAULT("01"), // 고장
    FULL("02") // 만석
    ;

    private final String code;

    ElevatorStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
