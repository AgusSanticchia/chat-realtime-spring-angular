package com.agus.springboot.backend.chat.app.services.impl;

import com.agus.springboot.backend.chat.app.models.Message;
import com.agus.springboot.backend.chat.app.repositories.MessageRepository;
import com.agus.springboot.backend.chat.app.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Service("messageServiceImpl")
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> findLast10Messages() {
        return messageRepository.findTop10ByOrderByDateDesc();
    }
}
