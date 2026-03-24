package com.matheus.gerenciadorDeAlunos.backend.GlobalException;

public class NenhumProfessorEncontrado extends RuntimeException {
    public NenhumProfessorEncontrado(String message) {
        super(message);
    }
}
