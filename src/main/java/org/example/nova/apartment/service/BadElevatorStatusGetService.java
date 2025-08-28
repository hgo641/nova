package org.example.nova.apartment.service;

import org.example.nova.apartment.dto.ElevatorStatusGetRequestToApartmentServer;
import org.example.nova.apartment.dto.ElevatorStatusResponseFromApartmentServer;
import org.springframework.stereotype.Service;

@Service
public class BadElevatorStatusGetService implements ElevatorStatusGetService {
    @Override
    public ElevatorStatusResponseFromApartmentServer getElevatorStatus(ElevatorStatusGetRequestToApartmentServer request) {
        try {
            // 10초간 대기
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
