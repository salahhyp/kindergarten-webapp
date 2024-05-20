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
@Table(name = "educator")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class educator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subject")
    private String subject;

    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;



    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private user user;

    @PostPersist
    private void linkUserToEducator() {
        if (user != null && user.getId() != null) {
            user.setEducator(this);
        }
    }
    @JsonManagedReference
    @OneToMany(mappedBy = "educator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<evaluation> evaluations;


}