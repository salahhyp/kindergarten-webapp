package com.daaw.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "evaluation")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    private child child;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "educator_id", nullable = false)
    private educator educator;

    @Column(name = "mark", nullable = false)
    private double mark;

    @Column(name = "comment", nullable = false)
    private String comment;
}
