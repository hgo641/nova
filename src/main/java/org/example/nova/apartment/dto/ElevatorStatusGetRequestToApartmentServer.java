package org.example.nova.apartment.dto;

public class ElevatorStatusGetRequestToApartmentServer {
    private final String dong;
    private final String hogi;

    public ElevatorStatusGetRequestToApartmentServer(String dong, String hogi) {
        this.dong = dong;
        this.hogi = hogi;
    }

    public String getDong() {
        return dong;
    }

    public String getHogi() {
        return hogi;
    }
}
