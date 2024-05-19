package com.daaw.project.dto;

import com.daaw.project.model.child.Plan;
import com.daaw.project.model.child.Schedule;

import lombok.Data;

@Data

public class ChildDto {
    String name;
    Long age;
    Plan plan;
    Schedule schedule;
    Long parentId;


}
