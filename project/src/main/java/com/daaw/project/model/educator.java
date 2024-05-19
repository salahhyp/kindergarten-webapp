package com.daaw.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}