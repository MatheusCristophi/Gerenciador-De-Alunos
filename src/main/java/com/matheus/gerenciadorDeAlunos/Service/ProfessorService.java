package com.matheus.gerenciadorDeAlunos.Service;

import com.matheus.gerenciadorDeAlunos.Domain.Professores;
import com.matheus.gerenciadorDeAlunos.GlobalException.AlunoNaoEncontrado;
import com.matheus.gerenciadorDeAlunos.GlobalException.ProfessorNaoCriado;
import com.matheus.gerenciadorDeAlunos.GlobalException.ProfessorNaoDeletado;
import com.matheus.gerenciadorDeAlunos.Repository.ProfessoresRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class ProfessorService {
    ProfessoresRepositorio repositorio;

    public ProfessorService(ProfessoresRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Professores saveProfessor(Professores professores){
        try{return repositorio.save(professores);
    } catch (ProfessorNaoCriado e) {
            throw new ProfessorNaoCriado(e.getMessage());
        }
    }
    public ResponseEntity<Professores> deleteProfessor(Long id){
        try{
            repositorio.deleteById(id);
            return new ResponseEntity(HttpStatus.GONE);
        } catch (ProfessorNaoDeletado e) {
            throw new ProfessorNaoDeletado(e.getMessage());
        }

    }
}
