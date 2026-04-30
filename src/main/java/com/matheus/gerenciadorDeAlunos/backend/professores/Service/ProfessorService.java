package com.matheus.gerenciadorDeAlunos.backend.professores.Service;

import com.matheus.gerenciadorDeAlunos.backend.professores.model.Professores;
import com.matheus.gerenciadorDeAlunos.backend.professores.Repository.ProfessoresRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service

public class ProfessorService {
    ProfessoresRepositorio repositorio;

    public ProfessorService(ProfessoresRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Transactional
    public Professores registrar(Professores professores){
        return repositorio.save(professores);
    }

    public List<Professores> showAllTeachers(){
        return repositorio.findAll();
    }

    public Professores showTeacherById(UUID id){
        return repositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
    }

    @Transactional
    public void deleteTeacherById(UUID professorId){
        Professores prof = repositorio.findById(professorId)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
        repositorio.delete(prof);
    }

    @Transactional
    public Professores updateTeatcher(UUID id, Professores prof){
        Professores profAtt = repositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
        if (prof.getName() != null) {
            profAtt.setName(prof.getName());
        }
        if(prof.getEmail() != null){
            profAtt.setEmail(prof.getEmail());
        }
        if (prof.getIdade() != 0) {
            profAtt.setIdade(prof.getIdade());
        }
        if (prof.getAlunos() != null) {
            profAtt.setAlunos(prof.getAlunos());
        }
        return repositorio.save(profAtt);
    }
}
