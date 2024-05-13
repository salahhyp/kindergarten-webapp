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
    @Column(name = "name")
    private String name;
    @Column(name = "childName")
    private String childName;
    @Column(name = "age")
    private Long age;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String Phone;
    @Enumerated(EnumType.STRING)
    @Column(name = "plan")
    private Plan plan;
    @Enumerated(EnumType.STRING)
    @Column(name = "schedule")
    private Schedule schedule;

    public enum Plan {
        TODDLER,
        PRESCHOOL,
        KINDERGARTEN
    }

    public enum Schedule {
        HALF_DAY,
        FULL_DAY
    }
}
