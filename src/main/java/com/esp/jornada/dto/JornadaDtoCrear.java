package com.esp.jornada.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record JornadaDtoCrear(
        @NotNull
        @Size(min = 1, max = 150)
        String nombreJornada,

        @NotNull
        Short estadoJornada
) {
}
