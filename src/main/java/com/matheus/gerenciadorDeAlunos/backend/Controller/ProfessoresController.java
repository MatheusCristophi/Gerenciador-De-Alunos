package com.matheus.gerenciadorDeAlunos.backend.Controller;

import com.matheus.gerenciadorDeAlunos.backend.Domain.Professores;
import com.matheus.gerenciadorDeAlunos.backend.Service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/manager")
public class ProfessoresController {
    ProfessorService service;

    public ProfessoresController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping("/alluser")
    public ResponseEntity<List<Professores>> getAllUser(){
        return new ResponseEntity<>(service.showAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Professores> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(service.showTeacherById(id), HttpStatus.OK);
    }

    @PostMapping("/saveuser")
    public ResponseEntity<Professores> saveUser(@RequestBody Professores prof){
        return new ResponseEntity<>(service.saveProfessor(prof), HttpStatus.CREATED);
    }

    @PutMapping("/updateuser")
    public ResponseEntity<Professores> updateUser(@PathVariable Long id, @RequestBody Professores prof){
        return new ResponseEntity<>(service.updateTeatcher(prof, id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
