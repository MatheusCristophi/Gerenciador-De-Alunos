package com.matheus.gerenciadorDeAlunos.backend.alunos.model;

import com.matheus.gerenciadorDeAlunos.backend.professores.model.Professores;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "tb_alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID alunoId;
    private String nome;
    private int periodo;
    @ElementCollection
    @CollectionTable(name = "tb_notas_alunos", joinColumns = @JoinColumn(name = "aluno_id"))
    private List<Float> notasT;
    @ManyToMany(mappedBy = "alunos")
    private Set<Professores> professores = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alunos alunos = (Alunos) o;
        return Objects.equals(alunoId, alunos.alunoId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(alunoId);
    }
}
