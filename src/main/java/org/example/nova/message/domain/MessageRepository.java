package org.example.nova.message.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Repository
public class MessageRepository {

    private static long id = 1;
    private static final Map<Long, Message> messageRepository = new HashMap<>();

    public Message findById(Long id) {
        if (!messageRepository.containsKey(id)){
            throw new NoSuchElementException("주어진 아이디에 해당하는 메시지가 존재하지 않습니다. 아이디 : " + id);
        }

        return messageRepository.get(id);
    }

    public long createMessage(Message message) {
        long messageId = id;
        id = id + 1;

        messageRepository.put(messageId, message);
        return messageId;
    }
}
