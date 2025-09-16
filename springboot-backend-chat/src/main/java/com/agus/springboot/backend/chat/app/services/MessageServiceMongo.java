package com.agus.springboot.backend.chat.app.services;

import com.agus.springboot.backend.chat.app.models.Message;
import com.agus.springboot.backend.chat.app.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageServiceMongo")
public class MessageServiceMongo implements MessageService {

    @Autowired
    private MessageRepository repository;

    @Override
    public Message save(Message message) {
        return repository.save(message);
    }

    @Override
    public List<Message> findLast10Messages() {
        return repository.findTop10ByOrderByDateDesc();
    }
}
