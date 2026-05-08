package com.matheus.gerenciadorDeAlunos.backend.config.securityController.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank
                           String email,
                           @NotBlank
                           String senha) {
}
