package org.example.nova.bus.service;

import org.example.nova.bus.dto.BusArrivalRequest;
import org.example.nova.bus.dto.BusArrivalResponse;

public interface BusService {

    BusArrivalResponse getBusArrival(BusArrivalRequest busArrivalRequest);
}
