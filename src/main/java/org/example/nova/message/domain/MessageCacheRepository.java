package org.example.nova.message.domain;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Optional;

@Repository
public class MessageCacheRepository {

    private static final String PREFIX = "message:";

    private final RedisTemplate<String, Object> redisTemplate;

    public MessageCacheRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(Message message) {
        String key = PREFIX + message.getId();
        redisTemplate.opsForValue().set(key, message, Duration.ofMinutes(1));
    }

    public Optional<Message> findById(Long id) {
        String key = PREFIX + id;
        Object value = redisTemplate.opsForValue().get(key);
        return Optional.ofNullable((Message) value);
    }

    public void delete(Long id) {
        redisTemplate.delete(PREFIX + id);
    }
}
