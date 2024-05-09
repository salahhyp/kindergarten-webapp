package com.daaw.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="preinscrit")
@Setter  @Getter @AllArgsConstructor @NoArgsConstructor
public class preinscrit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private Long email;
    @Column(name = "password")
    private Long password;
    @Column(name = "name")
    private Long name;
    @Column(name = "adress")
    private Long adress;
}
