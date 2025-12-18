package org.example.nova.robot.dto;

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
