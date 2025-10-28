package com.esp.rol.dto;

import jakarta.validation.constraints.NotNull;

public record RolDtoCrear(

        String nombreRol,
        @NotNull(message = "El campo estado no debe ser null")
        Short estadoRol) {
}
