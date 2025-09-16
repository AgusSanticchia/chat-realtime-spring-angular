package com.agus.springboot.backend.chat.app.services;

import org.springframework.stereotype.Service;
import com.agus.springboot.backend.chat.app.models.Message;
import com.agus.springboot.backend.chat.app.repositories.MessageRepository;
import java.util.List;

@Service
public class MessageServiceMongo implements MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Message> findAll() {
        return repository.findFirst10ByOrderByDateAsc();
    }

    @Override
    public void save(Message message) {
        repository.save(message);
    }

}
