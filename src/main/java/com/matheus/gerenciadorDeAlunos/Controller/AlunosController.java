package com.matheus.gerenciadorDeAlunos.Controller;

import com.matheus.gerenciadorDeAlunos.Domain.Alunos;
import com.matheus.gerenciadorDeAlunos.Service.AlunosService;
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
    public List<Alunos> mostrarTodosOsAlunos(){
        return service.mostrarTodosAlunos();
    }
    @GetMapping("/leralunoporid/{id}")
    public Alunos mostrarAlunoPeloId(@PathVariable Long id){
        return service.mostrarAlunoViaId(id);
    }
    @PostMapping("/salvaraluno")
    public Alunos salvarAlunos(@RequestBody Alunos alunos){
        return service.salvarAluno(alunos);
    }
    @PutMapping("/atualizaraluno/{id}")
    public Alunos alunoAtualizado(@RequestBody Alunos alunos,@PathVariable Long id){
        return service.atualizarAluno(alunos, id);
    }
    @DeleteMapping("/deletealuno/{id}")
    public void deletaraluno(@PathVariable Long id){
        service.deletarAluno(id);
    }
}
