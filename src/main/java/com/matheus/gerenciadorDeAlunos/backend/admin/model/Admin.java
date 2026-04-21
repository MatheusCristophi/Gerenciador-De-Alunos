package com.matheus.gerenciadorDeAlunos.backend.admin.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "administrador")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "admin_id", nullable = false)
    private UUID id;

    @Column(name = "admin_name", nullable = false)
    private String nome;

    @Column(name = "admin_email", unique = true , nullable = false)
    private String email;

    @Column(name = "admin_password", nullable = false)
    private String senha;
}
