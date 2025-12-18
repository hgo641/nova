package org.example.nova.message.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.nova.message.domain.Message;

@Mapper
public interface MessageMapper {
    Message findById(Long id);

    int insert(Message message);
}
