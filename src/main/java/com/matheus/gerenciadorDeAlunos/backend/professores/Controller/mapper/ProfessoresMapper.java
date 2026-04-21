package com.matheus.gerenciadorDeAlunos.backend.professores.Controller.mapper;

import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.request.ProfessoresRequest;
import com.matheus.gerenciadorDeAlunos.backend.professores.Controller.response.ProfessoresResponse;
import com.matheus.gerenciadorDeAlunos.backend.professores.model.Professores;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProfessoresMapper {

    public static Professores requestProfessores(ProfessoresRequest request){

        return Professores
                .builder()
                .name(request.nome())
                .idade(request.idade())
                .build();
    }

    public static ProfessoresResponse responseProfessores(Professores professores){
        return ProfessoresResponse
                .builder()
                .nome(professores.getName())
                .idade(professores.getIdade())
                .alunos(professores.getAlunos())
                .build();
    }
}
