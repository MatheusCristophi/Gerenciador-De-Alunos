package com.matheus.gerenciadorDeAlunos.backend.professores.Controller;

import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.mapper.ProfessoresMapper;
import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.request.ProfessoresRequest;
import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.response.ProfessoresResponse;
import com.matheus.gerenciadorDeAlunos.backend.professores.Service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ProfessoresResponse>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.showAllTeachers()
                    .stream()
                    .map(ProfessoresMapper::responseProfessores)
                    .toList());
    }

    @GetMapping("/getuser")
    public ResponseEntity<ProfessoresResponse> getUserById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(ProfessoresMapper.responseProfessores(service.showTeacherById(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<ProfessoresResponse> registrar(@RequestBody @Valid ProfessoresRequest professores){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProfessoresMapper.responseProfessores(service.registrar(ProfessoresMapper.requestProfessores(professores))));
    }

    @PutMapping("/update")
    public ResponseEntity<ProfessoresResponse> updateUser(@PathVariable UUID id, @RequestBody @Valid ProfessoresRequest professores){
        return ResponseEntity.status(HttpStatus.OK)
                .body(ProfessoresMapper.responseProfessores(service.updateTeatcher(id, ProfessoresMapper.requestProfessores(professores))));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id){
        service.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
