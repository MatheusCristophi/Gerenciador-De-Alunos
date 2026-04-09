package com.matheus.gerenciadorDeAlunos.backend.alunos.controller;

import com.matheus.gerenciadorDeAlunos.backend.alunos.model.Alunos;
import com.matheus.gerenciadorDeAlunos.backend.alunos.service.AlunosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class AlunosController {
    AlunosService service;

    public AlunosController(AlunosService service) {
        this.service = service;
    }

    @GetMapping("/read")
    public ResponseEntity<List<Alunos>> mostrarTodosOsAlunos(){
        return ResponseEntity.ok(service.mostrarTodosAlunos());
    }

    @GetMapping("/readById/{id}")
    public ResponseEntity<Alunos> mostrarAlunoPeloId(@PathVariable UUID alunosId){
        return ResponseEntity.ok(service.mostrarAlunoViaId(alunosId));
    }

    @PostMapping("/save")
    public ResponseEntity<Alunos> salvarAlunos(@RequestBody Alunos alunos){
        service.salvarAluno(alunos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Alunos> alunoAtualizado(@RequestBody Alunos alunos,@PathVariable UUID alunosId){
        service.atualizarAluno(alunos, alunosId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Alunos> deletaraluno(@PathVariable UUID alunosId){
        service.deletarAluno(alunosId);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
