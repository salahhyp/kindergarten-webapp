package com.daaw.project.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="message")
@Setter  @Getter @AllArgsConstructor @NoArgsConstructor
public class message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private parent sender;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private admin recipient;

    @CreationTimestamp
    private LocalDateTime timestamp;

}
