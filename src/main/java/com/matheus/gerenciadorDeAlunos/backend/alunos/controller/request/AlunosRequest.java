package com.matheus.gerenciadorDeAlunos.backend.alunos.controller.request;

import lombok.Builder;

@Builder
public record AlunosRequest(String nome,
                            int periodo) {
}
