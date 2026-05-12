package com.matheus.gerenciadorDeAlunos.backend.shared.exceptions.adminExceptions;

public class AdminFindEmailException extends RuntimeException {
    public AdminFindEmailException(String message) {
        super(message);
    }
}
