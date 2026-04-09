package com.matheus.gerenciadorDeAlunos.backend.alunos.repository;

import com.matheus.gerenciadorDeAlunos.backend.alunos.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunosRepositorio extends JpaRepository<Alunos, Long> {

}
