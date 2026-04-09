package com.matheus.gerenciadorDeAlunos.backend.professores.Controller;

import com.matheus.gerenciadorDeAlunos.backend.professores.model.Professores;
import com.matheus.gerenciadorDeAlunos.backend.professores.Service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/manager")
public class ProfessoresController {
    ProfessorService service;

    public ProfessoresController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Professores>> getAllUser(){
        return new ResponseEntity<>(service.showAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/getuser")
    public ResponseEntity<Professores> getUserById(@PathVariable UUID professorId){
        return new ResponseEntity<>(service.showTeacherById(professorId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Professores> saveUser(@RequestBody Professores prof){
        return new ResponseEntity<>(service.saveProfessor(prof), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Professores> updateUser(@PathVariable UUID professorId, @RequestBody Professores prof){
        return new ResponseEntity<>(service.updateTeatcher(prof, professorId), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID professorId){
        service.deleteTeacherById(professorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
