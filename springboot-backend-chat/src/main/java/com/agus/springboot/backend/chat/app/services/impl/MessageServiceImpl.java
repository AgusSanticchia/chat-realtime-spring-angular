package com.agus.springboot.backend.chat.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.agus.springboot.backend.chat.app.models.Message;
import com.agus.springboot.backend.chat.app.services.MessageService;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private final List<Message> messages = new ArrayList<>();

    @Override
    public List<Message> findAll() {
        return messages;
    }

    @Override
    public void save(Message message) {
        messages.add(message);
    }

}
