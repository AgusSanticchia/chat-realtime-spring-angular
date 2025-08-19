package com.agus.springboot.backend.chat.app.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    private String text;
    private Long date;
}
