package com.example.forum_hub.model.classes;

import com.example.forum_hub.model.dto.TopicsDTO;
import com.example.forum_hub.repository.ProfileRepository;
import com.example.forum_hub.service.TokenService;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

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
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Profiles author;
    private String group_name;

    public Profiles getAuthor() {
        return author;
    }

    public void setAuthor(Profiles author) {
        this.author = author;
    }

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
