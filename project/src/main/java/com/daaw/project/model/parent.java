package com.daaw.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Column(name = "name")
    private String name;


    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Location> locations = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "parent")
    private List<child> children;

    @JsonIgnore
    @OneToMany(mappedBy = "parent")
    private List<payment> payments;

    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<event> events = new ArrayList<>();


    @JsonIgnore
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
