package com.daaw.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "session")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "day")
    private String day;

    @Column(name = "time")
    private String time;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private group group;

    @ManyToOne
    @JoinColumn(name = "educator_id")
    private educator educator;
}