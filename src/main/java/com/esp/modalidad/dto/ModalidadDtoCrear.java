package com.esp.modalidad.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ModalidadDtoCrear(
        @NotBlank(message = "El nombre de la modalidad no puede estar vacío")
        @Size(max = 150, message = "El nombre no puede exceder los 150 caracteres")
        String nombreModalidad) {
}
