package com.matheus.gerenciadorDeAlunos.backend.alunos.controller;

import com.matheus.gerenciadorDeAlunos.backend.alunos.model.Alunos;
import com.matheus.gerenciadorDeAlunos.backend.alunos.service.AlunosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlunosController {
    AlunosService service;

    public AlunosController(AlunosService service) {
        this.service = service;
    }

    @GetMapping("/leraluno")
    public ResponseEntity<List<Alunos>> mostrarTodosOsAlunos(){
        return ResponseEntity.ok(service.mostrarTodosAlunos());
    }

    @GetMapping("/leralunoporid/{id}")
    public ResponseEntity<Alunos> mostrarAlunoPeloId(@PathVariable Long id){
        return ResponseEntity.ok(service.mostrarAlunoViaId(id));
    }

    @PostMapping("/salvaraluno")
    public ResponseEntity<Alunos> salvarAlunos(@RequestBody Alunos alunos){
        service.salvarAluno(alunos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/atualizaraluno/{id}")
    public ResponseEntity<Alunos> alunoAtualizado(@RequestBody Alunos alunos,@PathVariable Long id){
        service.atualizarAluno(alunos, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletealuno/{id}")
    public ResponseEntity<Alunos> deletaraluno(@PathVariable Long id){
        service.deletarAluno(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
