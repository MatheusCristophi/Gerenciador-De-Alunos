package com.matheus.gerenciadorDeAlunos.GlobalException;

public class ProfessorNaoDeletado extends RuntimeException {
    public ProfessorNaoDeletado(String message) {
        super("Não foi possivel deletar o professor");
    }
}
