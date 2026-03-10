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

public class Professores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;
    String name;
    byte idade;
}
