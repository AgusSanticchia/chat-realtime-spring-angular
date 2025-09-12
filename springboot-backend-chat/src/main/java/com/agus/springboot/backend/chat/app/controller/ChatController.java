package com.agus.springboot.backend.chat.app.controller;

import com.agus.springboot.backend.chat.app.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Random;

@Controller
public class ChatController {
    private String[] colors = {"red", "green", "blue", "magenta", "purple", "orange"};
    @MessageMapping("/message")
    @SendTo("/chat/message")
    public Message receiveMessage(Message message) {
        message.setDate(new Date().getTime());
        if (message.getType().equals("NEW_USER")) {
            message.setColor(this.colors[new Random().nextInt(this.colors.length)]);
            message.setText("New user: " + message.getUsername());
        }
        return message;
    }
}
