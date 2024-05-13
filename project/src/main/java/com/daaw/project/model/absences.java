package com.daaw.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="absences")
@Setter  @Getter @AllArgsConstructor @NoArgsConstructor
public class absences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "justification")
    private String justification;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private child child;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private session session;

}
