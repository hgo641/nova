package org.example.nova.robot.domain;

public class Elevator {
    private String apartmentId;
    private String elevatorId;
    private String dong;
    private String hogi;

    public Elevator(String apartmentId, String elevatorId, String dong, String hogi) {
        this.apartmentId = apartmentId;
        this.elevatorId = elevatorId;
        this.dong = dong;
        this.hogi = hogi;
    }

    public Elevator() {
    }

    public Elevator(String apartmentId, String dong, String hogi) {
        this.apartmentId = apartmentId;
        this.dong = dong;
        this.hogi = hogi;
    }

    public void setElevatorId(String elevatorId) {
        this.elevatorId = elevatorId;
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

    public String getElevatorId() {
        return elevatorId;
    }
}
