package com.example.forum_hub.model.dto;

import com.example.forum_hub.model.classes.Topics;

import java.time.LocalDateTime;

public record TopicsReturnDTO(Long id, String title, String message, String group, LocalDateTime date, Boolean status) {
    public TopicsReturnDTO(Topics topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getGroup_name(), topic.getDateTime(), topic.getStatus());
    }

}
