package com.agus.springboot.backend.chat.app.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "messages")
public class Message {

    @Id
    private  String id;

    private String text;
    private Long date;
    private String username;
    private String type;
    private String color;
}
