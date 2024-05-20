package com.daaw.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private String name;
    private String category;
    private Double price;
    private Long parentId;
    private Long adminId;
}
