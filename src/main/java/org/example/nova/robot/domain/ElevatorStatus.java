package org.example.nova.robot.domain;

public enum ElevatorStatus {
    NORMAL("00", "정상운행"), // 정상운행
    FAULT("01", "고장"), // 고장
    FULL("02", "만석") // 만석
    ;

    private final String code;
    private final String message;

    ElevatorStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ElevatorStatus fromCode(String code) {
        for (ElevatorStatus status : ElevatorStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("사용하지 않는 엘리베이터 상태 코드입니다. 코드 : " + code);
    }
}
