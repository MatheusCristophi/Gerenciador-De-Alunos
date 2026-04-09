package com.matheus.gerenciadorDeAlunos.backend.professores.model;

import com.matheus.gerenciadorDeAlunos.backend.alunos.model.Alunos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
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
    @GeneratedValue(strategy = GenerationType.UUID)
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Professores that = (Professores) o;
        return Objects.equals(professorId, that.professorId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(professorId);
    }
}
