package com.matheus.gerenciadorDeAlunos.backend.GlobalException;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(String message) {
        super("Aluno Não foi encontrado");
    }
}
