package com.matheus.gerenciadorDeAlunos.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Notas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notas {
    float nota1;
    float nota2;
    float nota3;
    float nota4;
}
