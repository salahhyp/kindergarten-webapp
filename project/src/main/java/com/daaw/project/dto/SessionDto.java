package com.daaw.project.dto;

import lombok.Data;

@Data
public class SessionDto {
    private String moduleName;
    private String day;
    private String time;
    private Long groupId;
    private Long educatorId;
}
