package com.matheus.gerenciadorDeAlunos.backend.GlobalException;

public class NenhumAlunoCadastrado extends RuntimeException {
    public NenhumAlunoCadastrado(String message) {
        super("Nenhum aluno foi cadastrado");
    }
}
