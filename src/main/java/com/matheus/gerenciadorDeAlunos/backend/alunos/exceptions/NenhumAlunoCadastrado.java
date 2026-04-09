package com.matheus.gerenciadorDeAlunos.backend.alunos.exceptions;

public class NenhumAlunoCadastrado extends RuntimeException {
    public NenhumAlunoCadastrado(String message) {
        super("Nenhum aluno foi cadastrado");
    }
}
