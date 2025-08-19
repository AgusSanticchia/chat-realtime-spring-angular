package com.agus.springboot.backend.chat.app.controller;

import com.agus.springboot.backend.chat.app.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/message")
    @SendTo("/chat/message")
    public Message receiveMessage(Message message) {
        message.setDate(new Date().getTime());
        message.setText("Recibo por el broker: " + message.getText());
        return message;
    }
}