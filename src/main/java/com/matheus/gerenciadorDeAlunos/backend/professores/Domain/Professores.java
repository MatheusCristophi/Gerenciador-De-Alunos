package com.matheus.gerenciadorDeAlunos.backend.professores.Domain;

import com.matheus.gerenciadorDeAlunos.backend.alunos.model.Alunos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "professores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private byte idade;
    @ManyToMany
    @JoinColumn(name = "professores")
    private Set<Alunos> alunos = new HashSet<>();
}
