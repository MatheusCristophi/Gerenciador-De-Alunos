package com.matheus.gerenciadorDeAlunos.backend.admin.controller.mappper;

import com.matheus.gerenciadorDeAlunos.backend.admin.controller.request.AdminRequest;
import com.matheus.gerenciadorDeAlunos.backend.admin.controller.response.AdminResponse;
import com.matheus.gerenciadorDeAlunos.backend.admin.model.Admin;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AdminMapper {

    public static Admin adminRequest(AdminRequest request){
        return Admin
                .builder()
                .nome(request.nome())
                .email(request.email())
                .senha(request.senha())
                .build();
    }

    public static AdminResponse adminResponse(Admin admin){
        return AdminResponse
                .builder()
                .nome(admin.getNome())
                .email(admin.getEmail())
                .build();
    }
}
