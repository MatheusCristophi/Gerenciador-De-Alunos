package com.matheus.gerenciadorDeAlunos.backend.professores.GlobalException;

public class ProfessorNaoCriado extends RuntimeException {
    public ProfessorNaoCriado(String message) {
        super("Não foi possivel criar o Professor");
    }
}
