package com.matheus.gerenciadorDeAlunos.backend.professores.Service;

import com.matheus.gerenciadorDeAlunos.backend.professores.model.Professores;
import com.matheus.gerenciadorDeAlunos.backend.professores.Repository.ProfessoresRepositorio;
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
public class ProfessorService implements UserDetailsService {
    private final ProfessoresRepositorio repositorio;
    private final PasswordEncoder encoder;

    @Transactional
    public Professores registrar(Professores professores){
        String senha = professores.getSenha();
        professores.setSenha(encoder.encode(senha));
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
        if(prof.getSenha() != null){
            profAtt.setSenha(encoder.encode(prof.getSenha()));
        }
        if (prof.getIdade() != 0) {
            profAtt.setIdade(prof.getIdade());
        }
        if (prof.getAlunos() != null) {
            profAtt.setAlunos(prof.getAlunos());
        }
        return repositorio.save(profAtt);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repositorio.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("Email ou Senha inválida"));
    }
}
