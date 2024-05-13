package com.daaw.project.Controllers;
import com.daaw.project.model.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import com.daaw.project.repositories.messageRepository;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final messageRepository messageRepository;
    @Autowired
    public ChatController(com.daaw.project.repositories.messageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @PostMapping("/send")
    public ResponseEntity<message> sendMessage(@RequestBody message message) {
        // Save the message to the database
        message savedMessage = messageRepository.save(message);
        return ResponseEntity.ok(savedMessage);
    }}


