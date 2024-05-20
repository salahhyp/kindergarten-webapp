package com.daaw.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "child")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;
    @Enumerated(EnumType.STRING)
    @Column(name = "plan")
    private Plan plan;

    @Enumerated(EnumType.STRING)
    @Column(name = "schedule")
    private Schedule schedule;
    public enum Plan {
        TODDLER,
        PRESCHOOL,
        KINDERGARTEN
    }

    public enum Schedule {
        HALF_DAY,
        FULL_DAY
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "group_id")
    private group group;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private parent parent;

    @JsonManagedReference
    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<evaluation> evaluations;

}