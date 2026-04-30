package com.matheus.gerenciadorDeAlunos.backend.admin.controller;

import com.matheus.gerenciadorDeAlunos.backend.admin.controller.mappper.AdminMapper;
import com.matheus.gerenciadorDeAlunos.backend.admin.controller.request.AdminRequest;
import com.matheus.gerenciadorDeAlunos.backend.admin.controller.response.AdminResponse;
import com.matheus.gerenciadorDeAlunos.backend.admin.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public ResponseEntity<AdminResponse> registrar(@Valid AdminRequest request){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                AdminMapper.adminResponse(service.registrar(AdminMapper.adminRequest(request)))
        );
    }
}
