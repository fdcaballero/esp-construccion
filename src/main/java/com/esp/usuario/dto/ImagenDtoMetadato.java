package com.esp.usuario.dto;

public record ImagenDtoMetadato(
        String nombrePublico,
        String nombrePrivado,
        String tipoImagen,
        String tamanio,
        Short favorita
){
}
