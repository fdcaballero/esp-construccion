package com.esp.estadovacante.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EstadoVacanteDtoCrear(
        @NotNull
        @Size(min = 1, max = 100)
        String nombreEstadoVacante,
        @NotNull
        Short ordenEstadoVacante
) {
}
