package com.matheus.gerenciadorDeAlunos.backend.alunos.controller;

import com.matheus.gerenciadorDeAlunos.backend.alunos.controller.mapper.AlunosMapper;
import com.matheus.gerenciadorDeAlunos.backend.alunos.controller.request.AlunosRequest;
import com.matheus.gerenciadorDeAlunos.backend.alunos.controller.response.AlunosResponse;
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
    public ResponseEntity<List<AlunosResponse>> mostrarTodosOsAlunos(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.mostrarTodosAlunos()
                        .stream()
                        .map(AlunosMapper::responseMapper)
                        .toList());
    }

    @GetMapping("/readById/{id}")
    public ResponseEntity<AlunosResponse> mostrarAlunoPeloId(@PathVariable UUID id){
        AlunosResponse alunoBuscado = AlunosMapper.responseMapper(service.mostrarAlunoViaId(id));
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(AlunosMapper.responseMapper(service.mostrarAlunoViaId(id)));
    }

    @PostMapping("/save")
    public ResponseEntity<AlunosResponse> salvarAlunos(@RequestBody AlunosRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AlunosMapper.responseMapper(service.salvarAluno(AlunosMapper.RequestMapper(request))));
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<AlunosResponse> alunoAtualizado(@RequestBody AlunosRequest alunos,@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(AlunosMapper.responseMapper(service.atualizarAluno(AlunosMapper.RequestMapper(alunos), id)));
    }

    @DeleteMapping("/delete/{id}")
    public void deletaraluno(@PathVariable UUID id){
        service.deletarAlunoViaId(id);
    }
}
