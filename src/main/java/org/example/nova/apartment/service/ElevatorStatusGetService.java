package org.example.nova.apartment.service;

import org.example.nova.apartment.dto.ElevatorStatusGetRequestToApartmentServer;
import org.example.nova.apartment.dto.ElevatorStatusResponseFromApartmentServer;

public interface ElevatorStatusGetService {
    ElevatorStatusResponseFromApartmentServer getElevatorStatus(ElevatorStatusGetRequestToApartmentServer request);
}
