package org.example.nova.robot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.nova.robot.dto.ElevatorRequest;
import org.example.nova.robot.dto.ElevatorResponse;

import java.util.List;

@Mapper
public interface RobotMapper {
    List<ElevatorResponse> findByApartmentId(String apartmentId);

    void createElevator(ElevatorRequest elevatorRequest);
}
