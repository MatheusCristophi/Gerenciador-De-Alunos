package com.matheus.gerenciadorDeAlunos.backend.professores.GlobalException;

public class NenhumProfessorEncontrado extends RuntimeException {
    public NenhumProfessorEncontrado(String message) {
        super(message);
    }
}
