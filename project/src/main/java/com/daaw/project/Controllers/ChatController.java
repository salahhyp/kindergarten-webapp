package com.daaw.project.Controllers;
import com.daaw.project.model.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import com.daaw.project.repositories.messageRepository;
import com.daaw.project.dto.MessageDto;
import com.daaw.project.services.messageService;
import java.util.List;
import com.daaw.project.model.parent;
import com.daaw.project.model.admin;
import com.daaw.project.services.messageService;
import com.daaw.project.services.parentService;
import com.daaw.project.services.adminService;
import java.time.LocalDateTime;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private messageService messageService;

    @GetMapping("/parent/{parentId}")
    public ResponseEntity<List<message>> getMessagesByParentId(@PathVariable Long parentId) {
        List<message> messages = messageService.getMessagesByParentId(parentId);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<MessageDto>> getMessagesByAdminId(@PathVariable Long adminId) {
        List<MessageDto> messages = messageService.getMessagesByAdminId(adminId);
        return ResponseEntity.ok(messages);
    }
    @GetMapping("/conversation/{adminId}/{parentId}")
    public ResponseEntity<List<MessageDto>> getConversation(@PathVariable Long adminId, @PathVariable Long parentId) {
        List<MessageDto> messages = messageService.getMessagesByAdminIdAndParentId(adminId, parentId);
        return ResponseEntity.ok(messages);
    }

    @PostMapping("/send")
    public ResponseEntity<MessageDto> sendMessage(@RequestBody MessageDto MessageDto) {
        try {
            MessageDto savedMessage = messageService.saveMessage(MessageDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMessage);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }}


