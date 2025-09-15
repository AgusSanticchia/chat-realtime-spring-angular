package com.agus.springboot.backend.chat.app.controller;

import com.agus.springboot.backend.chat.app.models.Message;
import com.agus.springboot.backend.chat.app.services.MessageService;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Random;
import java.util.List;

@Controller
public class ChatController {
    private String[] colors = {"red", "green", "blue", "magenta", "purple", "orange"};
    private final MessageService service;

    @Autowired
    private SimpMessagingTemplate template;

    public ChatController(MessageService service) {
        this.service = service;
    }

    @MessageMapping("/message")
    @SendTo("/chat/message")
    public Message receiveMessage(Message message) {
        message.setDate(new Date().getTime());
        if (message.getType().equals("NEW_USER")) {
            message.setColor(this.colors[new Random().nextInt(this.colors.length)]);
            message.setText("New user: " + message.getUsername());
        }else {
            service.save(message);
        }
        return message;
    }

    @MessageMapping("/writing")
    @SendTo("/chat/writing")
    public String isWriting(String username) {
        return username.concat(" is writing...");
    }

    @MessageMapping("/history")
    public void getHistoryMessage(String clientId) {
        template.convertAndSend("/chat/history/" + clientId, service.findAll());
    }
}
