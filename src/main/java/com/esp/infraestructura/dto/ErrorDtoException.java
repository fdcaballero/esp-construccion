package com.esp.infraestructura.dto;

import java.time.OffsetDateTime;

public class ErrorDtoException {
    private final int codigo;
    private final OffsetDateTime fechaHora;
    private final String error;
    private final String mensaje;

    public ErrorDtoException(int codigo, OffsetDateTime fechaHora, String error, String mensaje) {
        this.codigo = codigo;
        this.fechaHora = fechaHora;
        this.error = error;
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public OffsetDateTime getFechaHora() {
        return fechaHora;
    }

    public String getError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }
}
