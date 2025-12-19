package org.example.nova.message.domain;

public interface MessageRepository {
    Message findById(Long id);

    int createMessage(Message message);
}
