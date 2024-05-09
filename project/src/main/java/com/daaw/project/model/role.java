package com.daaw.project.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

@Entity
public class role {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
