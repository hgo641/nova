package org.example.nova.message.domain;

import java.time.LocalDateTime;

public class Message {
    private Long id;
    private final String message;
    private final LocalDateTime createdAt;

    public Message(String message) {
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    public Message(Long id, String message, LocalDateTime createdAt) {
        this.id = id;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
