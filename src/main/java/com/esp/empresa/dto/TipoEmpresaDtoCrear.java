package com.esp.empresa.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TipoEmpresaDtoCrear(

        @NotNull
        @Size(min = 1, max = 150)
        String nombreTipoEmpresa,
        @NotNull
        Short estadoTipoEmpresa
) {
}
