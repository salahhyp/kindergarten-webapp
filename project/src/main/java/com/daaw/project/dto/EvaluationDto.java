package com.daaw.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationDto {
    private Long childId;
    private Long educatorId;
    private double mark;
    private String comment;
}
