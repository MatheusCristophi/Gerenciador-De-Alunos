package com.matheus.gerenciadorDeAlunos.backend.alunos.controller.response;

import com.matheus.gerenciadorDeAlunos.backend.professores.model.Professores;
import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record AlunosResponse(UUID id,
                             String nome,
                             int periodo,
                             Set<Float> notasT,
                             Set<Professores> professores) {
}
