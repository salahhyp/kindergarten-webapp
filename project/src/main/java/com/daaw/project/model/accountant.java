package com.daaw.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="accountant")
@Setter  @Getter @AllArgsConstructor @NoArgsConstructor
public class accountant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nom ")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "adress")
    private String adress;


    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private user user;

    @PostPersist
    private void linkUserToAccountant() {
        if (user != null && user.getId() != null) {
            user.setAccountant(this); // Use the correct property name
        }
    }
}
