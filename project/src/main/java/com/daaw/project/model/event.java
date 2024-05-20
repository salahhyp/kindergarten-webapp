package com.daaw.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="event")
@Setter  @Getter @AllArgsConstructor @NoArgsConstructor
public class event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;


    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private parent parent;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private admin admin;

}
