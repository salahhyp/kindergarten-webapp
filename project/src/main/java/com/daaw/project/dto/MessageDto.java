package com.daaw.project.dto;

import java.time.LocalDateTime;
import lombok.Data;
public class MessageDto {
    private Long id;
    private Long parentId;
    private Long adminId;
    private String content;
    private LocalDateTime timestamp;
    private String sender;

    public Long getId() {
        return id;
    }

    public Long getParentId() {
        return parentId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getSender() {
        return sender;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
