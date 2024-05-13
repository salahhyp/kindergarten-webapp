package com.daaw.project.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="session")
@Setter  @Getter @AllArgsConstructor
@NoArgsConstructor
public class session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "module_name")
    private String module_name;
    @Column(name = "time")
    private String time;

    @OneToMany(mappedBy = "session")
    private List<absences> absences;

    @ManyToOne
    @JoinColumn(name = "educator_id")
    private educator educator;

}
