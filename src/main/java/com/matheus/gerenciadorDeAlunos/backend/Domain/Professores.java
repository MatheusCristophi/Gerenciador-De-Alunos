package com.matheus.gerenciadorDeAlunos.backend.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Professores")
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
