package com.matheus.gerenciadorDeAlunos.backend.shared.exceptions.adminExceptions;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminFindEmailError {
    private String message;
    private String error;
    private int status;
    private LocalDateTime timestamp;
}
