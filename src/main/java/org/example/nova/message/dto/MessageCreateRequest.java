package org.example.nova.message.dto;

public class MessageCreateRequest {
    private String message;

    public MessageCreateRequest(String message) {
        this.message = message;
    }

    public MessageCreateRequest() {
    }

    public String getMessage() {
        return message;
    }
}
