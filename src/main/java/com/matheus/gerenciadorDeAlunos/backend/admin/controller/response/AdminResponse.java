package com.matheus.gerenciadorDeAlunos.backend.admin.controller.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record AdminResponse(UUID id, //necessário para testes, remover quando acabar.
                            String nome,
                            String email) {
}
