package com.matheus.gerenciadorDeAlunos.backend.alunos.service;

import com.matheus.gerenciadorDeAlunos.backend.alunos.model.Alunos;
import com.matheus.gerenciadorDeAlunos.backend.alunos.repository.AlunosRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlunosService implements UserDetailsService {
    private final AlunosRepositorio repositorio;
    private final PasswordEncoder encoder;

    @Transactional
    public Alunos registrarAluno(Alunos alunos){
        String senha = alunos.getSenha();
        alunos.setSenha(encoder.encode(senha));
        return repositorio.save(alunos);
    }


    @Transactional
    public void deletarAlunoViaId(UUID id){
        try{
        repositorio.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public List<Alunos> mostrarTodosAlunos(){
        return repositorio.findAll();
    }


    public Alunos mostrarAlunoViaId(UUID id){
        return repositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Id inválido"));
    }


    public Alunos atualizarAluno(Alunos alunos, UUID id){
            Alunos alunoExistente = repositorio.findById(id)
                    .orElseThrow(() -> new RuntimeException("Id não encontrado"));
            if (alunos.getNome() != null){
                alunoExistente.setNome(alunos.getNome());
            }else{
                alunoExistente.setNome(alunoExistente.getNome());
            }
            if (alunos.getPeriodo() != 0){
                alunoExistente.setPeriodo(alunos.getPeriodo());
            }else{
                alunoExistente.setPeriodo(alunoExistente.getPeriodo());
            }
            if (alunos.getProfessores() != null){
                alunoExistente.setProfessores(alunos.getProfessores());
            }else{
                alunoExistente.setProfessores(alunoExistente.getProfessores());
            }
            if (alunos.getSenha() != null){
                alunoExistente.setSenha(encoder.encode(alunos.getSenha()));
            }
            if (alunos.getNotasT() != null){
                alunoExistente.setNotasT(alunos.getNotasT());
            }else{
                alunoExistente.setAlunoId(alunoExistente.getAlunoId());
            }
            return repositorio.save(alunoExistente);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repositorio.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("Email ou Senha inválida"));
    }
}
