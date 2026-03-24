package com.matheus.gerenciadorDeAlunos.backend.Repository;

import com.matheus.gerenciadorDeAlunos.backend.Domain.Professores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessoresRepositorio extends JpaRepository<Professores, Long> {
}
