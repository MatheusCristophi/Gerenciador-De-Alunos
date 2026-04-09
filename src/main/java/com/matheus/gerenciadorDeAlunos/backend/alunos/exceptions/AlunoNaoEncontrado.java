package com.matheus.gerenciadorDeAlunos.backend.alunos.exceptions;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(String message) {
        super("Aluno Não foi encontrado");
    }
}
