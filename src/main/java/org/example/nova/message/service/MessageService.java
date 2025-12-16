package org.example.nova.message.service;

import org.example.nova.message.domain.Message;
import org.example.nova.message.domain.MessageRepository;
import org.example.nova.message.dto.MessageCreateRequest;
import org.example.nova.message.dto.MessageResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Transactional(readOnly = true)
    public MessageResponse getMessage(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("메시지가 존재하지 않습니다. id=" + id));

        return new MessageResponse(message.getMessage(), message.getCreatedAt());
    }

    @Transactional
    public Long createMessage(MessageCreateRequest messageCreateRequest) {
        Message savedMessage = messageRepository.save(new Message(messageCreateRequest.getMessage()));
        return savedMessage.getId();
    }
}
