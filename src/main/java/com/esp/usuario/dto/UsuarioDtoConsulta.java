package com.esp.usuario.dto;

public record UsuarioDtoConsulta(int idUsuario,
                                 String nombres,
                                 String apellidos,
                                 String identificacion,
                                 String ubicacion) {
}
