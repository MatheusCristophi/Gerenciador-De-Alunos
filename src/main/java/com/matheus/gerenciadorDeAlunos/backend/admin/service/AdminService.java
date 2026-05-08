package com.matheus.gerenciadorDeAlunos.backend.admin.service;

import com.matheus.gerenciadorDeAlunos.backend.admin.model.Admin;
import com.matheus.gerenciadorDeAlunos.backend.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService{

    private final AdminRepository repository;
    private final PasswordEncoder encoder;

    @Transactional
    public Admin registrar(Admin admin){
        if (repository.findByEmail(admin.getEmail()).isPresent()){
            throw new RuntimeException("Email ja cadastrado");
        }
        String password = admin.getSenha();
        admin.setSenha(encoder.encode(password));
        return repository.save(admin);
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }
}
