package com.matheus.gerenciadorDeAlunos.backend.professores.Service;

import com.matheus.gerenciadorDeAlunos.backend.professores.model.Professores;
import com.matheus.gerenciadorDeAlunos.backend.professores.Repository.ProfessoresRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class ProfessorService {
    ProfessoresRepositorio repositorio;

    public ProfessorService(ProfessoresRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Professores saveProfessor(Professores professores){
        return repositorio.save(professores);
    }
    public List<Professores> showAllTeachers(){
        return repositorio.findAll();
    }
    public Professores showTeacherById(UUID professorId){
        return repositorio.findById(professorId)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
    }
    public void deleteTeacherById(UUID professorId){
        Professores prof = repositorio.findById(professorId)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
        repositorio.delete(prof);

    }
    public Professores updateTeatcher(Professores prof, UUID professorId){
        Professores profEx = repositorio.findById(professorId)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
        profEx.setName(prof.getName());
        profEx.setIdade(prof.getIdade());
        profEx.setAlunos(prof.getAlunos());
        return repositorio.save(profEx);
    }
}
