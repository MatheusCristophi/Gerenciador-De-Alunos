package com.matheus.gerenciadorDeAlunos.GlobalException;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(String message) {
        super("Aluno Não foi encontrado");
    }
}
