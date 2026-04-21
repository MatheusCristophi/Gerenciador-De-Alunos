package com.matheus.gerenciadorDeAlunos.backend.professores.model;

import com.matheus.gerenciadorDeAlunos.backend.alunos.model.Alunos;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_professores")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Professores {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(nullable = false)
    private UUID professorId;
    private String name;
    private int idade;
    @ManyToMany
    @JoinTable(
            name = "alunos_professores",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private Set<Alunos> alunos;
}
