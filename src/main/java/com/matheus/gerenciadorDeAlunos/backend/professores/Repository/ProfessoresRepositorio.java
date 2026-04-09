package com.matheus.gerenciadorDeAlunos.backend.professores.Repository;

import com.matheus.gerenciadorDeAlunos.backend.professores.Domain.Professores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessoresRepositorio extends JpaRepository<Professores, UUID> {
}
