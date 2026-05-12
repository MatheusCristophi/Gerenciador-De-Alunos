package com.matheus.gerenciadorDeAlunos.backend.shared.exceptions.adminExceptions;

public class AdminDeleteException extends RuntimeException {
    public AdminDeleteException(String message) {
        super(message);
    }
}
