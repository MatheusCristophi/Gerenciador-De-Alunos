package com.matheus.gerenciadorDeAlunos.backend.alunos.model;

import com.matheus.gerenciadorDeAlunos.backend.professores.model.Professores;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "tb_alunos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID alunoId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int periodo;

    @ElementCollection
    @CollectionTable(name = "tb_notas_alunos", joinColumns = @JoinColumn(name = "aluno_id"))
    private Set<Float> notasT;

    @ManyToMany(mappedBy = "alunos")
    private Set<Professores> professores = new HashSet<>();
}
