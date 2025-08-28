package org.example.nova.message.dto;

import java.time.LocalDateTime;

public class MessageResponse {
    private final String message;
    private final LocalDateTime createdAt;

    public MessageResponse(String message, LocalDateTime createdAt) {
        this.message = message;
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
