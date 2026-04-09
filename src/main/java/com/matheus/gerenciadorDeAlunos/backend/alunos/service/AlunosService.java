package com.matheus.gerenciadorDeAlunos.backend.alunos.service;

import com.matheus.gerenciadorDeAlunos.backend.alunos.exceptions.AlunoNaoEncontrado;
import com.matheus.gerenciadorDeAlunos.backend.alunos.model.Alunos;
import com.matheus.gerenciadorDeAlunos.backend.alunos.repository.AlunosRepositorio;

import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
public class AlunosService {
    final AlunosRepositorio repositorio;

    public AlunosService(AlunosRepositorio alunosRepositorio) {
        this.repositorio = alunosRepositorio;
    }

    public Alunos salvarAluno(Alunos alunos){
            return repositorio.save(alunos);
    }
    public void deletarAluno(UUID alunosId){
        Alunos alunoId = repositorio.findById(alunosId)
                .orElseThrow(() -> new RuntimeException("Id do Aluno não existe"));
        repositorio.delete(alunoId);
    }
    public List<Alunos> mostrarTodosAlunos(){
            return repositorio.findAll();
    }
    public Alunos mostrarAlunoViaId(UUID alunosId){
        return repositorio.findById(alunosId)
                .orElseThrow(() -> new AlunoNaoEncontrado("Id do Aluno não encontrado"));
    }
    public Alunos atualizarAluno(Alunos alunos, UUID alunosId){
            Alunos alunoExistente = repositorio.findById(alunosId)
                    .orElseThrow(() -> new RuntimeException("Id não encontrado"));
            alunoExistente.setNome(alunos.getNome());
            alunoExistente.setPeriodo(alunos.getPeriodo());
            return repositorio.save(alunoExistente);
    }
}
