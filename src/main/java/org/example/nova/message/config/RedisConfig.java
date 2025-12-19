//package org.example.nova.message.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.*;
//
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(
//            RedisConnectionFactory connectionFactory,
//            ObjectMapper objectMapper
//    ) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//
//        // Key는 String
//        template.setKeySerializer(new StringRedisSerializer());
//
//        // Value는 JSON
//        template.setValueSerializer(
//                new GenericJackson2JsonRedisSerializer(objectMapper)
//        );
//
//        return template;
//    }
//}
