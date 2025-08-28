package org.example.nova.apartment.domain;

public class Elevator {
    private ElevatorStatus elevatorStatus;
    private ElevatorDoorStatus doorStatus;
    private Integer currentFloor;

    public Elevator(ElevatorStatus elevatorStatus, ElevatorDoorStatus doorStatus, Integer currentFloor) {
        this.elevatorStatus = elevatorStatus;
        this.doorStatus = doorStatus;
        this.currentFloor = currentFloor;
    }

    public ElevatorStatus getElevatorStatus() {
        return elevatorStatus;
    }

    public ElevatorDoorStatus getDoorStatus() {
        return doorStatus;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
