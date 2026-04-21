package com.matheus.gerenciadorDeAlunos.backend.professores.Controller.response;

import com.matheus.gerenciadorDeAlunos.backend.alunos.model.Alunos;
import lombok.Builder;

import java.util.Set;

@Builder
public record ProfessoresResponse(String nome,
                                  int idade,
                                  Set<Alunos> alunos) {
}
