package org.example.nova.message.service;

import org.example.nova.message.domain.Message;
import org.example.nova.message.domain.MessageRepository;
import org.example.nova.message.dto.MessageCreateRequest;
import org.example.nova.message.dto.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageResponse getMessage(Long id) {
        Message message = messageRepository.findById(id);
        return new MessageResponse(message.getMessage(), message.getCreatedAt());
    }

    public Long createMessage(MessageCreateRequest messageCreateRequest) {
        Message message = new Message(messageCreateRequest.getMessage());
        long messageId = messageRepository.createMessage(message);
        return messageId;
    }
}
