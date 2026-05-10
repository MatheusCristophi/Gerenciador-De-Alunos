package com.matheus.gerenciadorDeAlunos.backend.professores.Controller;

import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.mapper.ProfessoresMapper;
import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.request.ProfessoresRequest;
import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.response.ProfessoresResponse;
import com.matheus.gerenciadorDeAlunos.backend.professores.Service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/professor")
public class ProfessoresController {
    ProfessorService service;

    public ProfessoresController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<List<ProfessoresResponse>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.showAllTeachers()
                    .stream()
                    .map(ProfessoresMapper::responseProfessores)
                    .toList());
    }

    @GetMapping("/getuser/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<ProfessoresResponse> getUserById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(ProfessoresMapper.responseProfessores(service.showTeacherById(id)));
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<ProfessoresResponse> updateUser(@PathVariable UUID id, @RequestBody @Valid ProfessoresRequest professores){
        return ResponseEntity.status(HttpStatus.OK)
                .body(ProfessoresMapper.responseProfessores(service.updateTeatcher(id, ProfessoresMapper.requestProfessores(professores))));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id){
        service.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
