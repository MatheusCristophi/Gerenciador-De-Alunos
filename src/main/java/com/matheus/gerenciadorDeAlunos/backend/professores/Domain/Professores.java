package com.matheus.gerenciadorDeAlunos.backend.professores.Domain;

import com.matheus.gerenciadorDeAlunos.backend.alunos.model.Alunos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_professores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private UUID professorId;
    private String name;
    private byte idade;
    @ManyToMany
    @JoinTable(
            name = "alunos_professores",
            joinColumns = @JoinColumn(name = "professores_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private Set<Alunos> alunos = new HashSet<>();
}
