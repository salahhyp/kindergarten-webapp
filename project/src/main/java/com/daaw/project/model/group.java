package com.daaw.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "childrenGroups")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class group {
    public static final int MAX_CAPACITY = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "plan")
    private Plan plan;

    @Enumerated(EnumType.STRING)
    @Column(name = "schedule")
    private Schedule schedule;

    @JsonManagedReference
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<child> children;

    @JsonIgnore
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<session> sessions;

    public group(String planString, String scheduleString) {
        this.plan = Plan.valueOf(planString.toUpperCase());
        this.schedule = Schedule.valueOf(scheduleString.toUpperCase());
    }

    public enum Plan {
        TODDLER,
        PRESCHOOL,
        KINDERGARTEN
    }

    public enum Schedule {
        HALF_DAY,
        FULL_DAY
    }
}