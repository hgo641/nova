package org.example.nova.robot.service;

import org.example.nova.robot.dto.ElevatorRequest;
import org.example.nova.robot.dto.ElevatorResponse;
import org.example.nova.robot.mapper.RobotMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotService {

    private final RobotMapper robotMapper;

    public RobotService(RobotMapper robotMapper) {
        this.robotMapper = robotMapper;
    }

    public List<ElevatorResponse> getElevators(String apartmentId) {
        return robotMapper.findByApartmentId(apartmentId);
    }


    public void createElevator(ElevatorRequest elevatorRequest) {
        robotMapper.createElevator(elevatorRequest);
    }
}
