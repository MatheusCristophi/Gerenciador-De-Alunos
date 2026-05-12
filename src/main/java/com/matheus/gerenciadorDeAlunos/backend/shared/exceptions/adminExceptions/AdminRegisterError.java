package com.matheus.gerenciadorDeAlunos.backend.shared.exceptions.adminExceptions;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminRegisterError {
    private String message;
    private String error;
    private int status;
    private LocalDateTime timestamp;
}
