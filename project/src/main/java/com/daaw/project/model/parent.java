package com.daaw.project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="parent")
@Setter  @Getter @AllArgsConstructor @NoArgsConstructor
public class parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Location> locations = new ArrayList<>();

    @OneToMany(mappedBy = "parent")
    private List<event> events;

    @OneToMany(mappedBy = "parent")
    private List<child> children;

    @OneToMany(mappedBy = "parent")
    private List<payment> payments;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private user user;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<message> messages = new ArrayList<>();

    @PostPersist
    private void linkUserToParent() {
        if (user != null && user.getId() != null) {
            user.setParent(this); // Use the correct property name
        }
    }
}
