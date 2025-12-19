package org.example.nova.robot.controller;

import org.example.nova.robot.dto.ElevatorRequest;
import org.example.nova.robot.dto.ElevatorResponse;
import org.example.nova.robot.service.RobotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/robot")
public class RobotController {

    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @GetMapping("/elevator/{apartmentId}")
    public ResponseEntity<List<ElevatorResponse>> getElevatorList(@PathVariable String apartmentId) {
        List<ElevatorResponse> elevators = robotService.getElevators(apartmentId);
        return ResponseEntity.ok(elevators);
    }

    @PostMapping("/elevator")
    public ResponseEntity<Void> createElevator(@RequestBody ElevatorRequest elevatorRequest) {
        robotService.createElevator(elevatorRequest);
        return ResponseEntity.noContent().build();
    }
}
