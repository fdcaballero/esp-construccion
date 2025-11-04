package com.esp.usuario.dto;

public record UsuarioDtoRespuesta(
        String nombresUsuario,
        String apellidosUsuario,
        String documentoUsuario,
        Short tipoDocumentoUsuario,
        Short estadoUsuario) {
}
