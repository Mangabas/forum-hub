package com.example.forum_hub.model;

import jakarta.validation.constraints.NotBlank;

public record TopicsDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotBlank
        String group
) {
}
