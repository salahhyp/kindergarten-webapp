package com.daaw.project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.naming.Name;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
@Entity
@Table(name="admin")
@Setter  @Getter @AllArgsConstructor @NoArgsConstructor
public class admin {
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


    @OneToMany(mappedBy = "admin")
    private List<event> events;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private user user;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<message> messages = new ArrayList<>();
    @PostPersist
    private void linkUserToAdmin() {
        if (user != null && user.getId() != null) {
            user.setAdmin(this); // Use the correct property name
        }
    }

}
