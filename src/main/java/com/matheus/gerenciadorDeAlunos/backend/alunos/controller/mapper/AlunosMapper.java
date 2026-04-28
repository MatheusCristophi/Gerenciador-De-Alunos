package com.matheus.gerenciadorDeAlunos.backend.alunos.controller.mapper;

import com.matheus.gerenciadorDeAlunos.backend.alunos.controller.request.AlunosRequest;
import com.matheus.gerenciadorDeAlunos.backend.alunos.controller.response.AlunosResponse;
import com.matheus.gerenciadorDeAlunos.backend.alunos.model.Alunos;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AlunosMapper {

    public static Alunos RequestMapper(AlunosRequest request){
        return Alunos
                .builder()
                .nome(request.nome())
                .periodo(request.periodo())
                .email(request.email())
                .senha(request.senha())
                .build();
    }

    public static AlunosResponse responseMapper(Alunos alunos){
        return AlunosResponse
                .builder()
                .nome(alunos.getNome())
                .periodo(alunos.getPeriodo())
                .id(alunos.getAlunoId())
                .build();
    }
}
