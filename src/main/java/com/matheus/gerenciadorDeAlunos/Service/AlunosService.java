package com.matheus.gerenciadorDeAlunos.Service;

import com.matheus.gerenciadorDeAlunos.Domain.Alunos;
import com.matheus.gerenciadorDeAlunos.GlobalException.AlunoIdNaoEncontrado;
import com.matheus.gerenciadorDeAlunos.GlobalException.AlunoNaoCriado;
import com.matheus.gerenciadorDeAlunos.GlobalException.AlunoNaoEncontrado;
import com.matheus.gerenciadorDeAlunos.GlobalException.NenhumAlunoCadastrado;
import com.matheus.gerenciadorDeAlunos.Repository.AlunosRepositorio;

import java.util.List;

@org.springframework.stereotype.Service
public class AlunosService {
    final AlunosRepositorio repositorio;

    public AlunosService(AlunosRepositorio alunosRepositorio) {
        this.repositorio = alunosRepositorio;
    }

    public Alunos salvarAluno(Alunos alunos){
        try {
            return repositorio.save(alunos);
        } catch (AlunoNaoCriado e) {
            throw new AlunoNaoCriado(e.getMessage());
        }
    }
    public void deletarAluno(Long id){
        Alunos alunosId = repositorio.findById(id)
                .orElseThrow(() -> new AlunoIdNaoEncontrado("Id do Aluno não existe"));
        repositorio.delete(alunosId);
    }
    public List<Alunos> mostrarTodosAlunos(){
        try {
            return repositorio.findAll();
        } catch (NenhumAlunoCadastrado e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Alunos mostrarAlunoViaId(Long id){
        return repositorio.findById(id)
                .orElseThrow(() -> new AlunoNaoEncontrado("Id do Aluno não encontrado"));
    }
    public Alunos atualizarAluno(Alunos alunos, Long id){
        try {
            Alunos alunoExistente = repositorio.findById(id)
                    .orElseThrow(() -> new AlunoIdNaoEncontrado("Id não encontrado"));
            alunoExistente.setNome(alunos.getNome());
            alunoExistente.setPeriodo(alunos.getPeriodo());
            return repositorio.save(alunoExistente);
        } catch (AlunoNaoEncontrado e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
