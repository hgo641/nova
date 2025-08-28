package org.example.nova.robot.dto;

public class ElevatorStatusGetRequest {
    private final String apartmentId;
    private final String dong;
    private final String hogi;

    public ElevatorStatusGetRequest(String apartmentId, String dong, String hogi) {
        this.apartmentId = apartmentId;
        this.dong = dong;
        this.hogi = hogi;
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
