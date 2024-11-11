package com.baraujo.pagamentoms.controller.dto;

import com.baraujo.pagamentoms.entity.Carteira;
import com.baraujo.pagamentoms.entity.TipoCarteira;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CarteiraDto(@NotBlank String nome,
                          @NotBlank String cpfCnpj,
                          @NotBlank String email,
                          @NotBlank String senha,
                          @NotNull TipoCarteira.Tipo tipoCarteira) {

    public Carteira toCarteira() {
        return new Carteira(
                nome,
                cpfCnpj,
                email,
                senha,
                tipoCarteira.get()
        );
    }
}
