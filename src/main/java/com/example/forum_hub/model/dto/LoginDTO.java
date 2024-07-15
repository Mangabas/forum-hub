package com.example.forum_hub.model.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
