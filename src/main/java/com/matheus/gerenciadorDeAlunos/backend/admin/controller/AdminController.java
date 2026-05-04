package com.matheus.gerenciadorDeAlunos.backend.admin.controller;

import com.matheus.gerenciadorDeAlunos.backend.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private AdminService service;

    @DeleteMapping("delete")
    public void deleteById(@PathVariable UUID id){
        service.deleteById(id);
    }
}
