package com.baraujo.pagamentoms.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferirDto(@NotNull Long remetente,
                            @NotNull Long receptor,
                            @DecimalMin("0.01") @NotNull BigDecimal valor) {
}
