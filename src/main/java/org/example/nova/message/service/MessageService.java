//package org.example.nova.message.service;
//
//import org.example.nova.message.domain.Message;
//import org.example.nova.message.domain.MessageCacheRepository;
//import org.example.nova.message.domain.MessageRepository;
//import org.example.nova.message.dto.MessageCreateRequest;
//import org.example.nova.message.dto.MessageResponse;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@Service
//public class MessageService {
//
//    private final MessageRepository messageRepository;
//    private final MessageCacheRepository cacheRepository;
//
//    public MessageService(MessageRepository messageRepository, MessageCacheRepository cacheRepository) {
//        this.messageRepository = messageRepository;
//        this.cacheRepository = cacheRepository;
//    }
//
//    @Transactional(readOnly = true)
//    public MessageResponse getMessage(Long id) {
//        Optional<Message> byId = cacheRepository.findById(1L);
//
//        Message savedMessage = cacheRepository.findById(id)
//                .orElseGet(() -> {
//                    Message message = messageRepository.findById(id)
//                            .orElseThrow(() -> new IllegalArgumentException("메시지가 존재하지 않습니다. id=" + id));
//                    cacheRepository.save(message);
//                    return message;
//                });
//
//        return new MessageResponse(savedMessage.getMessage(), savedMessage.getCreatedAt());
//    }
//
//    @Transactional
//    public Long createMessage(MessageCreateRequest messageCreateRequest) {
//        Message savedMessage = messageRepository.save(new Message(messageCreateRequest.getMessage()));
//        cacheRepository.save(savedMessage);
//        return savedMessage.getId();
//    }
//}
