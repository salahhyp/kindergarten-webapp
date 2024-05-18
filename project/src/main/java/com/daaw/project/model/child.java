package com.daaw.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="child")
@Setter  @Getter @AllArgsConstructor @NoArgsConstructor
public class child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;

    @Column(name = "adress")
    private String adress;

    @Column(name = "age")
    private String age;


    @ManyToOne
    @JoinColumn(name = "parent_id")
    private parent parent;


    @OneToMany(mappedBy = "child")
    private List<absences> absences;

    @ManyToOne
    @JoinColumn(name = "educator_id")
    private educator educator;

}
