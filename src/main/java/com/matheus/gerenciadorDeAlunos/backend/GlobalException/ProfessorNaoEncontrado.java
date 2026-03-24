package com.matheus.gerenciadorDeAlunos.backend.GlobalException;

public class ProfessorNaoEncontrado extends RuntimeException {
    public ProfessorNaoEncontrado(String message) {
        super("Não foi possivel deletar o professor");
    }
}
