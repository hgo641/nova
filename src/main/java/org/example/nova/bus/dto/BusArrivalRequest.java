package org.example.nova.bus.dto;

public class BusArrivalRequest {
    private String stationId; // 121000944
    private String routeId; // 230000184
    private String staOrder; // 25

    public BusArrivalRequest(String stationId, String routeId, String staOrder) {
        this.stationId = stationId;
        this.routeId = routeId;
        this.staOrder = staOrder;
    }

    public String getStationId() {
        return stationId;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getStaOrder() {
        return staOrder;
    }
}
