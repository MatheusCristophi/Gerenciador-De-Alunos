package com.matheus.gerenciadorDeAlunos.backend.alunos.exceptions;

public class AlunoNaoCriado extends RuntimeException {
    public AlunoNaoCriado(String message) {
        super("Não foi possivel criar o Aluno");
    }
}
