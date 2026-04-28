package com.matheus.gerenciadorDeAlunos.backend.admin.controller.response;

import lombok.Builder;

@Builder
public record AdminResponse(String nome,
                            String email) {
}
