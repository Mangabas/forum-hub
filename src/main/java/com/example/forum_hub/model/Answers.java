package com.example.forum_hub.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime dateTime;
//    @OneToOne
//    @JoinColumn
//    private Profiles author;
    private String solution;
    @ManyToOne
    private Topics topic;


}
