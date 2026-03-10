package com.matheus.gerenciadorDeAlunos.GlobalException;

public class NenhumAlunoCadastrado extends RuntimeException {
    public NenhumAlunoCadastrado(String message) {
        super("Nenhum aluno foi cadastrado");
    }
}
