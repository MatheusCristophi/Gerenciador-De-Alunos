package com.matheus.gerenciadorDeAlunos.backend.admin.controller.request;

import lombok.Builder;

@Builder
public record AdminRequest(String nome,
                           String email,
                           String senha) {
}
