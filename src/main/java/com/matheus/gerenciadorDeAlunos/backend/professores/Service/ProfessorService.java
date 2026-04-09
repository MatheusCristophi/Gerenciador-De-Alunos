package com.matheus.gerenciadorDeAlunos.backend.professores.Service;

import com.matheus.gerenciadorDeAlunos.backend.professores.Domain.Professores;
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
    public Professores showTeacherById(UUID id){
        return repositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
    }
    public void deleteTeacherById(UUID id){
        Professores prof = repositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
        repositorio.delete(prof);

    }
    public Professores updateTeatcher(Professores prof, UUID id){
        Professores profEx = repositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
        profEx.setName(prof.getName());
        profEx.setIdade(prof.getIdade());
        //profEx.setListaAlunos(prof.getListaAlunos());
        return repositorio.save(profEx);
    }
}
