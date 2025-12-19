package org.example.nova.robot.dto;

import org.example.nova.robot.domain.Elevator;

public class ElevatorResponse {
    private String elevatorId;
    private String apartmentId;
    private String dong;
    private String hogi;

    public ElevatorResponse(String elevatorId, String apartmentId, String dong, String hogi) {
        this.elevatorId = elevatorId;
        this.apartmentId = apartmentId;
        this.dong = dong;
        this.hogi = hogi;
    }

    public static ElevatorResponse from(Elevator elevator) {
        return new ElevatorResponse(
                elevator.getElevatorId(),
                elevator.getApartmentId(),
                elevator.getDong(),
                elevator.getHogi()
        );
    }

    public String getElevatorId() {
        return elevatorId;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public String getDong() {
        return dong;
    }

    public String getHogi() {
        return hogi;
    }
}
