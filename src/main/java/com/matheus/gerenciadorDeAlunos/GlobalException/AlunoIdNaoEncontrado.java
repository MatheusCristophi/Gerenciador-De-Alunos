package com.matheus.gerenciadorDeAlunos.GlobalException;

public class AlunoIdNaoEncontrado extends RuntimeException {
    public AlunoIdNaoEncontrado(String message) {
        super("Id do Aluno não encontrado");
    }
}
