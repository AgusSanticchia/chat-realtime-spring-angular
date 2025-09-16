package com.agus.springboot.backend.chat.app.services;

import com.agus.springboot.backend.chat.app.models.Message;
import java.util.List;

public interface MessageService {
    Message save(Message message);
    List<Message> findLast10Messages();
}
