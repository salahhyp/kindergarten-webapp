package com.daaw.project.dto;

import com.daaw.project.model.child;
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
    Long groupId;
    private Long id;

    public ChildDto(child child) {
        this.id = child.getId();
        this.name = child.getName();
        this.age = child.getAge();
        this.plan = child.getPlan();
        this.schedule = child.getSchedule();
        this.parentId = child.getParent().getId();
        this.groupId = child.getGroup().getId();
    }
}
