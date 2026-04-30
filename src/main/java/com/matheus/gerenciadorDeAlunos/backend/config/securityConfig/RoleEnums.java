package com.matheus.gerenciadorDeAlunos.backend.config.securityConfig;

public enum RoleEnums {
    ALUNO("ROLE_ALUNO"),
    PROFESSOR("ROLE_PROFESSOR"),
    ADMINISTRADOR("ROLE_ADMINISTRADOR");

    private String role;

    RoleEnums(String role){
        this.role = role;
    }

    public String getRoleEnums(){
        return role;
    }
}
