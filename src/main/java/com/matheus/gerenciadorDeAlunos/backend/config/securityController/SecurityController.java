package com.matheus.gerenciadorDeAlunos.backend.config.securityController;

import com.matheus.gerenciadorDeAlunos.backend.admin.controller.mappper.AdminMapper;
import com.matheus.gerenciadorDeAlunos.backend.admin.controller.request.AdminRequest;
import com.matheus.gerenciadorDeAlunos.backend.admin.controller.response.AdminResponse;
import com.matheus.gerenciadorDeAlunos.backend.admin.service.AdminService;
import com.matheus.gerenciadorDeAlunos.backend.alunos.controller.mapper.AlunosMapper;
import com.matheus.gerenciadorDeAlunos.backend.alunos.controller.request.AlunosRequest;
import com.matheus.gerenciadorDeAlunos.backend.alunos.controller.response.AlunosResponse;
import com.matheus.gerenciadorDeAlunos.backend.alunos.service.AlunosService;
import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.mapper.ProfessoresMapper;
import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.request.ProfessoresRequest;
import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.response.ProfessoresResponse;
import com.matheus.gerenciadorDeAlunos.backend.professores.Service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class SecurityController {

    private final AdminService adminService;
    private final AlunosService alunosService;
    private final ProfessorService professorService;

    @PostMapping("admin/registrar")
    public ResponseEntity<AdminResponse> registrarAdmin(@RequestBody @Valid AdminRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AdminMapper.adminResponse(adminService.registrar(AdminMapper.adminRequest(request))));
    }

    @PostMapping("aluno/registrar")
    public ResponseEntity<AlunosResponse> registrarAluno(@RequestBody @Valid AlunosRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AlunosMapper.responseMapper(alunosService.registrarAluno(AlunosMapper.RequestMapper(request))));
    }

    @PostMapping
    public ResponseEntity<ProfessoresResponse> registrarProfessor(@RequestBody @Valid ProfessoresRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProfessoresMapper.responseProfessores(professorService.registrar(ProfessoresMapper.requestProfessores(request))));
    }
}
