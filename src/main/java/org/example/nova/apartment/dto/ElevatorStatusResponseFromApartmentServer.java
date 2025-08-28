package org.example.nova.apartment.dto;

public class ElevatorStatusResponseFromApartmentServer {
    private String elevatorStatus;
    private String doorStatus;
    private String currentFloor;

    public ElevatorStatusResponseFromApartmentServer(String elevatorStatus, String doorStatus, String currentFloor) {
        this.elevatorStatus = elevatorStatus;
        this.doorStatus = doorStatus;
        this.currentFloor = currentFloor;
    }

    public String getElevatorStatus() {
        return elevatorStatus;
    }

    public String getDoorStatus() {
        return doorStatus;
    }

    public String getCurrentFloor() {
        return currentFloor;
    }
}
