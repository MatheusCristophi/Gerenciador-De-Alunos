package com.matheus.gerenciadorDeAlunos.backend.admin.service;

import com.matheus.gerenciadorDeAlunos.backend.admin.model.Admin;
import com.matheus.gerenciadorDeAlunos.backend.admin.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    private final AdminRepository repository;

    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Admin registrar(Admin admin){
        return repository.save(admin);
    }

    @Transactional
    public Admin login(Admin email, Admin senha){
        Admin adminAtual = repository.findByEmailAndSenha(email, senha);
        return adminAtual;
    }
}
