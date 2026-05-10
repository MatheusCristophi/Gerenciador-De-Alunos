package com.matheus.gerenciadorDeAlunos.backend.config.securityService;

import com.matheus.gerenciadorDeAlunos.backend.admin.repository.AdminRepository;
import com.matheus.gerenciadorDeAlunos.backend.alunos.repository.AlunosRepositorio;
import com.matheus.gerenciadorDeAlunos.backend.professores.Repository.ProfessoresRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final AlunosRepositorio alunosRepositorio;
    private final ProfessoresRepositorio professoresRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var admin = adminRepository.findByEmail(email);
        if (admin.isPresent()) return admin.get();

        var aluno = alunosRepositorio.findByEmail(email);
        if (aluno.isPresent()) return aluno.get();

        var professor = professoresRepositorio.findByEmail(email);
        if (professor.isPresent()) return professor.get();

        throw new UsernameNotFoundException("Usuário ou senha incorreta");
    }
}
