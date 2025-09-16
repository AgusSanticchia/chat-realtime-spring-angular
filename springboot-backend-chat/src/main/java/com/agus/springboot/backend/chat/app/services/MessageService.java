package com.agus.springboot.backend.chat.app.services;

import java.util.List;

import com.agus.springboot.backend.chat.app.models.Message;
import org.springframework.stereotype.Service;

public interface MessageService {
    List<Message> findAll();
    public void save(Message message);
}
