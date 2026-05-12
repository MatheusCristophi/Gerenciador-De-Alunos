package com.matheus.gerenciadorDeAlunos.backend.shared.handlerException;

import com.matheus.gerenciadorDeAlunos.backend.shared.exceptions.adminExceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(AdminDeleteException.class)
    public ResponseEntity<AdminDeleteError> handlerAdminDelete(AdminDeleteException exception){
        AdminDeleteError error = AdminDeleteError.builder()
                .message(exception.getMessage())
                .error("AdminDeleteError")
                .status(400)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(AdminRegisterException.class)
    public ResponseEntity<AdminRegisterError> handlerAdminRegister(AdminRegisterException exception){
        AdminRegisterError error = AdminRegisterError.builder()
                .message(exception.getMessage())
                .error("AdminRegisterError")
                .status(400)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(AdminFindEmailException.class)
    public ResponseEntity<AdminFindEmailError> handlerAdminEmail(AdminFindEmailException exception){
        AdminFindEmailError error = AdminFindEmailError.builder()
                .message(exception.getMessage())
                .error("AdminFindEmailError")
                .status(400)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.badRequest().body(error);
    }
}
