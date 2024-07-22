package com.example.forum_hub.model.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicsDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        String group
) {
}
