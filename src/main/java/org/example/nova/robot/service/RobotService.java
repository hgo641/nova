package org.example.nova.robot.service;

import org.example.nova.robot.domain.Elevator;
import org.example.nova.robot.domain.ElevatorCacheRepository;
import org.example.nova.robot.dto.ElevatorRequest;
import org.example.nova.robot.dto.ElevatorResponse;
import org.example.nova.robot.mapper.RobotMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RobotService {

    // ttl = time to live / 상수로 사용(꼭 그래야 하는 건 X. 개인 선호도)
    private static final Duration ELEVATOR_TTL_WHEN_SAVED = Duration.ofMinutes(10);
    private static final Duration ELEVATOR_TTL_WHEN_READ = Duration.ofMinutes(30);

    private final RobotMapper robotMapper;
    private final ElevatorCacheRepository elevatorCacheRepository;

    public RobotService(RobotMapper robotMapper, ElevatorCacheRepository elevatorCacheRepository) {
        this.robotMapper = robotMapper;
        this.elevatorCacheRepository = elevatorCacheRepository;
    }

    public List<ElevatorResponse> getElevators(String apartmentId) {
        // 캐시에서 먼저 확인 후
        List<Elevator> cachedElevators = elevatorCacheRepository.findByApartmentId(apartmentId);

        // 캐시에 없으면 MySQL에서 다시 확인
        if (cachedElevators.isEmpty()) {
            List<Elevator> elevators = robotMapper.findByApartmentId(apartmentId);
            elevatorCacheRepository.saveAllInSameApartment(elevators, ELEVATOR_TTL_WHEN_READ);
        }
        return cachedElevators.stream().map(ElevatorResponse::from).toList();
    }

    @Transactional
    public void createElevator(ElevatorRequest elevatorRequest) {
        Elevator elevator = new Elevator(elevatorRequest.getApartmentId(), elevatorRequest.getDong(), elevatorRequest.getHogi());
        robotMapper.createElevator(elevator);

        // MySQL 뿐만아닌 Redis 캐시 서버에도 데이터를 저장
        elevatorCacheRepository.save(new Elevator(
                elevatorRequest.getApartmentId(),
                elevator.getElevatorId(),
                elevatorRequest.getDong(),
                elevatorRequest.getHogi()
        ), ELEVATOR_TTL_WHEN_SAVED);
    }
}
