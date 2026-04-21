package com.matheus.gerenciadorDeAlunos.backend.professores.Controller.request;

import lombok.Builder;

@Builder
public record ProfessoresRequest(String nome,
                                 int idade) {
}
