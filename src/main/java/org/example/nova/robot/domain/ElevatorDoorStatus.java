package org.example.nova.robot.domain;

public enum ElevatorDoorStatus {
    OPEN("열림"),
    CLOSE("닫힘"),
    ;

    private final String message;

    ElevatorDoorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
