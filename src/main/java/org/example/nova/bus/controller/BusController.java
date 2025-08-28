package org.example.nova.bus.controller;

import org.example.nova.bus.dto.BusArrivalRequest;
import org.example.nova.bus.dto.BusArrivalResponse;
import org.example.nova.bus.service.BusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus")
public class BusController {

//    private final BusService busService;
//
//    public BusController(BusService busService) {
//        this.busService = busService;
//    }
//
//    @GetMapping("/arrival")
//    public BusArrivalResponse getBusArrival(BusArrivalRequest busArrivalRequest) {
//        return busService.getBusArrival(busArrivalRequest);
//    }
}
