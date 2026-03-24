package com.matheus.gerenciadorDeAlunos.backend.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Notas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    int id;
    float nota1;
    float nota2;
    float nota3;
    float nota4;
}
