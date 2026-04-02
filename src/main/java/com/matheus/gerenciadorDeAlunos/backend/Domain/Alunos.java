package com.matheus.gerenciadorDeAlunos.backend.Domain;

import com.matheus.gerenciadorDeAlunos.backend.util.DateUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<Float> notasT;
}
