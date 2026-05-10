package com.matheus.gerenciadorDeAlunos.backend.config.securityController;

import com.matheus.gerenciadorDeAlunos.backend.admin.controller.mappper.AdminMapper;
import com.matheus.gerenciadorDeAlunos.backend.admin.controller.request.AdminRequest;
import com.matheus.gerenciadorDeAlunos.backend.admin.controller.response.AdminResponse;
import com.matheus.gerenciadorDeAlunos.backend.admin.service.AdminService;
import com.matheus.gerenciadorDeAlunos.backend.alunos.controller.mapper.AlunosMapper;
import com.matheus.gerenciadorDeAlunos.backend.alunos.controller.request.AlunosRequest;
import com.matheus.gerenciadorDeAlunos.backend.alunos.controller.response.AlunosResponse;
import com.matheus.gerenciadorDeAlunos.backend.alunos.service.AlunosService;
import com.matheus.gerenciadorDeAlunos.backend.config.securityController.request.LoginRequest;
import com.matheus.gerenciadorDeAlunos.backend.config.securityController.response.LoginResponse;
import com.matheus.gerenciadorDeAlunos.backend.config.securityService.SecurityService;
import com.matheus.gerenciadorDeAlunos.backend.config.tokenService.TokenService;
import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.mapper.ProfessoresMapper;
import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.request.ProfessoresRequest;
import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.response.ProfessoresResponse;
import com.matheus.gerenciadorDeAlunos.backend.professores.Service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class SecurityController {

    private final AdminService adminService;
    private final AlunosService alunosService;
    private final ProfessorService professorService;
    private final ObjectProvider<AuthenticationManager> authenticationManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("admin/registrar")
    public ResponseEntity<AdminResponse> registrarAdmin(@RequestBody @Valid AdminRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AdminMapper.adminResponse(adminService.registrar(AdminMapper.adminRequest(request))));
    }

    @PostMapping("aluno/registrar")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<AlunosResponse> registrarAluno(@RequestBody @Valid AlunosRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AlunosMapper.responseMapper(alunosService.registrarAluno(AlunosMapper.RequestMapper(request))));
    }

    @PostMapping("professor/registrar")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<ProfessoresResponse> registrarProfessor(@RequestBody @Valid ProfessoresRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProfessoresMapper.responseProfessores(professorService.registrar(ProfessoresMapper.requestProfessores(request))));
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        var userAndPassword = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        var auth = authenticationManager.getObject().authenticate(userAndPassword);
        var token = tokenService.generateToken((UserDetails) auth.getPrincipal());
        return ResponseEntity.ok((new LoginResponse(token)));
    }
}