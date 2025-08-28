package org.example.nova.robot.dto;

public class ElevatorStatusResponse {
    private String elevatorStatus;
    private String doorStatus;
    private String currentFloor;

    public ElevatorStatusResponse(String elevatorStatus, String doorStatus, String currentFloor) {
        this.elevatorStatus = elevatorStatus;
        this.doorStatus = doorStatus;
        this.currentFloor = currentFloor;
    }
}
