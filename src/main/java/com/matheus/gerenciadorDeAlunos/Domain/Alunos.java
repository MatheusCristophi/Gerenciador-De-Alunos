package com.matheus.gerenciadorDeAlunos.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String nome;
    private int periodo;
    private float notaFinal;
}
