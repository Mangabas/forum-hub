package com.example.forum_hub.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "profile")
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
//    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @Transient
//    private Answers answer;
//    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Topics post;

}
