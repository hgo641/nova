package org.example.nova.message.domain;

import org.example.nova.message.mapper.MessageMapper;
import org.springframework.stereotype.Component;

@Component
public class MybatisMessageRepository implements MessageRepository {

    private final MessageMapper messageMapper;

    public MybatisMessageRepository(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public Message findById(Long id) {
        return messageMapper.findById(id);
    }

    @Override
    public int createMessage(Message message) {
        return messageMapper.insert(message);
    }
}
