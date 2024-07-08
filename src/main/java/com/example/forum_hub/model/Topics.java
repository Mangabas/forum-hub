package com.example.forum_hub.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Topics")
public class Topics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @Column(unique = true)
    private String message;
    private LocalDateTime dateTime ;
    private Boolean status;
//    @OneToOne
//    @JoinColumn(name = "author_id")
//    private Profiles author;
    private String group_name;
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Answers> answers;

    public Topics(TopicsDTO topic) {
        this.title = topic.title();
        this.message = topic.message();
        this.dateTime = LocalDateTime.now().withNano(0);
        this.status = true;
        this.group_name = topic.group();
    }

    public Topics(){}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getGroup_name() {
        return group_name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void attTopic(TopicsDTO post) {
        if (post.title() != null){
            this.title = post.title();
        }
        if (post.message() != null){
            this.message = post.message();
        }
        if (post.group() != null){
            this.group_name = post.group();
        }
    }

    public void inativeTopic() {
        this.status = false;
    }

    public void activeTopic() {
        this.status = true;
    }
}
