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
import com.daaw.project.model.parent;
import com.daaw.project.model.admin;
import com.daaw.project.services.messageService;
import com.daaw.project.services.parentService;
import com.daaw.project.services.adminService;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private messageService messageService;

    @Autowired
    private parentService parentService;

    @Autowired
    private adminService adminService;

    @GetMapping("/parent/{parentId}")
    public List<message> getMessagesByParentId(@PathVariable Long parentId) {
        return messageService.getMessagesByParentId(parentId);
    }

    @GetMapping("/admin/{adminId}")
    public List<message> getMessagesByAdminId(@PathVariable Long adminId) {
        return messageService.getMessagesByAdminId(adminId);
    }

    @PostMapping("/send")
    public message sendMessage(@RequestParam Long parentId, @RequestParam Long adminId,
                               @RequestParam String content, @RequestParam String sender) {
        parent parent = parentService.getParentById(parentId);
        admin admin = adminService.getAdminById(adminId);
        if (parent != null && admin != null) {
            message message = new message();
            message.setParent(parent);
            message.setAdmin(admin);
            message.setContent(content);
            message.setTimestamp(LocalDateTime.now());
            message.setSender(com.daaw.project.model.message.Sender.valueOf(sender.toUpperCase()));
            return messageService.saveMessage(message);
        }
        return null;
    }}


