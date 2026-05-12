package com.matheus.gerenciadorDeAlunos.backend.shared.exceptions.adminExceptions;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdminDeleteError {
    private String message;
    private String error;
    private int status;
    private LocalDateTime timestamp;
}
