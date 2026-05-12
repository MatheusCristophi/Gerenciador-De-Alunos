package com.matheus.gerenciadorDeAlunos.backend.admin.service;

import com.matheus.gerenciadorDeAlunos.backend.admin.model.Admin;
import com.matheus.gerenciadorDeAlunos.backend.admin.repository.AdminRepository;
import com.matheus.gerenciadorDeAlunos.backend.shared.exceptions.adminExceptions.AdminDeleteException;
import com.matheus.gerenciadorDeAlunos.backend.shared.exceptions.adminExceptions.AdminFindEmailException;
import com.matheus.gerenciadorDeAlunos.backend.shared.exceptions.adminExceptions.AdminRegisterException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;
    private final PasswordEncoder encoder;

    @Transactional
    public Admin registrar(Admin admin) {
        if (repository.findByEmail(admin.getEmail()).isPresent()) {
            throw new AdminRegisterException("Email ja cadastrado");
        }
        try {
            String password = admin.getSenha();
            admin.setSenha(encoder.encode(password));
            return repository.save(admin);
        }catch(AdminRegisterException exception){
            throw new AdminRegisterException("Erro ao cadastrar um Administrador");
        }
    }

    public Admin buscarEmail(String email){
        try{
            return repository.findByEmail(email)
                    .orElseThrow(()-> new AdminFindEmailException("Não foi possível encontrar o email"));
        }catch(AdminFindEmailException exception){
            throw new AdminFindEmailException("O email não existe");
        }
    }

    @Transactional
    public void deleteById(UUID id) {
        try {
            repository.deleteById(id);
        } catch (AdminDeleteException exception) {
            throw new AdminDeleteException("Erro ao deletar o administrador");
        }
    }
}
