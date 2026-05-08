package com.matheus.gerenciadorDeAlunos.backend.config.securityService;

import com.matheus.gerenciadorDeAlunos.backend.admin.repository.AdminRepository;
import com.matheus.gerenciadorDeAlunos.backend.alunos.repository.AlunosRepositorio;
import com.matheus.gerenciadorDeAlunos.backend.config.securityController.request.LoginRequest;
import com.matheus.gerenciadorDeAlunos.backend.config.securityController.response.LoginResponse;
import com.matheus.gerenciadorDeAlunos.backend.config.tokenService.TokenService;
import com.matheus.gerenciadorDeAlunos.backend.professores.Repository.ProfessoresRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final AlunosRepositorio alunosRepositorio;
    private final ProfessoresRepositorio professoresRepositorio;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public LoginResponse login (LoginRequest request){
        var userAndPassword = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        var auth = authenticationManager.authenticate(userAndPassword);
        var token = tokenService.generateToken((UserDetails) auth.getPrincipal());
        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse(token)).getBody();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var admin = adminRepository.findByEmail(email);
        if (admin.isPresent()) return admin.get();

        var aluno = alunosRepositorio.findByEmail(email);
        if (aluno.isPresent()) return aluno.get();

        var professor = professoresRepositorio.findByEmail(email);
        if (professor.isPresent()) return professor.get();

        throw new UsernameNotFoundException("Usuário ou senha incorreta");
    }
}
