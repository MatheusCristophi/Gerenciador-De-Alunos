package com.matheus.gerenciadorDeAlunos.backend.Repository;

import com.matheus.gerenciadorDeAlunos.backend.Domain.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunosRepositorio extends JpaRepository<Alunos, Long> {

}
