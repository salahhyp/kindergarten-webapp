package com.daaw.project.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceDto {
    private Long id;
    private String description;
    private String justification;
    private Long childId;
    private LocalDate startDate;
    private LocalDate endDate;
}
