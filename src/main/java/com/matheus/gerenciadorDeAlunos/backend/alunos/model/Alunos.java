package com.matheus.gerenciadorDeAlunos.backend.alunos.model;

import com.matheus.gerenciadorDeAlunos.backend.shared.enums.RoleEnums;
import com.matheus.gerenciadorDeAlunos.backend.professores.model.Professores;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "tb_alunos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Alunos implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(nullable = false)
    private UUID alunoId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    public RoleEnums role = RoleEnums.ALUNO;

    @Column(nullable = false)
    private int periodo;

    @ElementCollection
    @CollectionTable(name = "tb_notas_alunos", joinColumns = @JoinColumn(name = "aluno_id"))
    @Column(name = "nota")
    private List<Float> notasT;

    @ManyToMany(mappedBy = "alunos")
    private List<Professores> professores;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRoleEnums()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
