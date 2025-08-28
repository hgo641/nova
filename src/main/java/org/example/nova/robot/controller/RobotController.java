package org.example.nova.robot.controller;

import org.example.nova.robot.dto.ElevatorStatusGetRequest;
import org.example.nova.robot.dto.ElevatorStatusResponse;
import org.example.nova.robot.service.RobotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/robot")
public class RobotController {

    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @GetMapping("/elevator/{apartmentId}/{dong}/{hogi}")
    public ResponseEntity<ElevatorStatusResponse> getElevatorStatus(@PathVariable String apartmentId, @PathVariable String dong, @PathVariable String hogi) {
        ElevatorStatusGetRequest elevatorStatusGetRequest = new ElevatorStatusGetRequest(apartmentId, dong, hogi);
        ElevatorStatusResponse elevatorStatusResponse = robotService.getElevatorStatus(elevatorStatusGetRequest);
        return ResponseEntity.ok(elevatorStatusResponse);
    }
}
