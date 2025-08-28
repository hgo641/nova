package org.example.nova.message.domain;

import java.time.LocalDateTime;

public class Message {
    private final String message;
    private final LocalDateTime createdAt;

    public Message(String message) {
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
