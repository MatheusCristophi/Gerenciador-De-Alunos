package com.matheus.gerenciadorDeAlunos.Service;

import com.matheus.gerenciadorDeAlunos.Domain.Alunos;
import com.matheus.gerenciadorDeAlunos.Repository.AlunosRepositorio;

import java.util.List;

@org.springframework.stereotype.Service
public class AlunosService {
    final AlunosRepositorio repositorio;

    public AlunosService(AlunosRepositorio alunosRepositorio) {
        this.repositorio = alunosRepositorio;
    }

    public Alunos salvarAluno(Alunos alunos){
        return repositorio.save(alunos);
    }
    public void deletarAluno(Long id){
        Alunos alunosId = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Id do Aluno não existe"));
        repositorio.delete(alunosId);
    }
    public List<Alunos> mostrarTodosAlunos(){
        return repositorio.findAll();
    }
    public Alunos mostrarAlunoViaId(Long id){
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }
    public Alunos atualizarAluno(Alunos alunos, Long id){
        Alunos alunoExistente = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));
        alunoExistente.setNome(alunos.getNome());
        alunoExistente.setPeriodo(alunos.getPeriodo());
        alunoExistente.setNotaFinal(alunos.getNotaFinal());
        return repositorio.save(alunoExistente);
    }
}
