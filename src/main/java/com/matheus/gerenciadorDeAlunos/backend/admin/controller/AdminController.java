package com.matheus.gerenciadorDeAlunos.backend.admin.controller;

import com.matheus.gerenciadorDeAlunos.backend.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @DeleteMapping("delete")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public void deleteById(@PathVariable UUID id){
        service.deleteById(id);
    }
}
