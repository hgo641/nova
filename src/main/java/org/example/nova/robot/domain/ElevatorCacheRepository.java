package org.example.nova.robot.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Repository
public class ElevatorCacheRepository {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    public ElevatorCacheRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(Elevator elevator, Duration ttl) {
        // 엘리베이터 객체를 가리킬 Key생성
        // 예시) elevator:apartment:1:101:1:2
        String key = "elevator:apartment:%s:%s:%s:%s"
                .formatted(elevator.getApartmentId(), elevator.getDong(), elevator.getHogi(), elevator.getElevatorId());

        redisTemplate.opsForValue().set(key, elevator, ttl);

        // 2. apartmentId 기준 인덱스 Set 저장
        // 예시) elevator:apartment:1 (하위의 모든 데이터 key를 저장/ 이후 findByApartmentId에서 사용)
        String indexKey = "elevator:apartment:" + elevator.getApartmentId();
        redisTemplate.opsForSet().add(indexKey, key);

        // TTL은 10분으로 설정
        redisTemplate.expire(indexKey, ttl);
    }

    // 같은 아파트에 속하는 엘리베이터 전체 저장
    public void saveAllInSameApartment(List<Elevator> elevators, Duration ttl) {
        if (elevators == null || elevators.isEmpty()) {
            return;
        }

        // 같은 apartmentId라고 가정 (아니면 아래에서 groupBy 필요)
        String apartmentId = elevators.get(0).getApartmentId();
        String indexKey = "elevator:apartment:" + apartmentId;

        for (Elevator elevator : elevators) {
            // elevator:apartment:{apartmentId}:{dong}:{hogi}:{elevatorId}
            String key = "elevator:apartment:%s:%s:%s:%s"
                    .formatted(
                            elevator.getApartmentId(),
                            elevator.getDong(),
                            elevator.getHogi(),
                            elevator.getElevatorId()
                    );

            // 개별 엘리베이터 저장
            redisTemplate.opsForValue().set(key, elevator, ttl);

            // 인덱스 Set에 key 추가
            redisTemplate.opsForSet().add(indexKey, key);
        }

        // 인덱스 key TTL 설정 (한 번만)
        redisTemplate.expire(indexKey, ttl);
    }

    public List<Elevator> findByApartmentId(String apartmentId) {
        String indexKey = "elevator:apartment:" + apartmentId;

        // elevator:apartment:{apartmentId} 하위의 모든 데이터 key를 탐색
        Set<Object> keySet = redisTemplate.opsForSet().members(indexKey);
        if (keySet == null || keySet.isEmpty()) {
            return List.of();
        }

        List<String> keys = new ArrayList<>(keySet).stream().map(key -> (String) key).toList();
        List<Object> elevators = redisTemplate.opsForValue().multiGet(keys);

        if (elevators == null) {
            return List.of();
        }

        return elevators.stream()
                .filter(Objects::nonNull)
                .map(ele -> mapper.convertValue(ele, Elevator.class))
                .toList();
    }
}
