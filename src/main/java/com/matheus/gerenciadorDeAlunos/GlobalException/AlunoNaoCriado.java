package com.matheus.gerenciadorDeAlunos.GlobalException;

public class AlunoNaoCriado extends RuntimeException {
    public AlunoNaoCriado(String message) {
        super("Não foi possivel criar o Aluno");
    }
}
