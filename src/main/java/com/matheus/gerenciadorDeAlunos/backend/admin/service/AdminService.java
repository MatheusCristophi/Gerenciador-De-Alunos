package com.matheus.gerenciadorDeAlunos.backend.admin.service;

import com.matheus.gerenciadorDeAlunos.backend.admin.model.Admin;
import com.matheus.gerenciadorDeAlunos.backend.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService implements UserDetailsService {

    private final AdminRepository repository;
    private final PasswordEncoder encoder;

    @Transactional
    public Admin registrar(Admin admin){
        String password = admin.getSenha();
        admin.setSenha(encoder.encode(password));
        return repository.save(admin);
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("Email ou Senha inválida"));
    }
}
