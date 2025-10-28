package com.esp.infraestructura.utils.respuesta;

import java.time.OffsetDateTime;

public class ResponseHttpModel<T> {

    private final int codigoEstado;
    private final OffsetDateTime fechaHora;
    private final String mensaje;
    private final T datos;

    public ResponseHttpModel(int codigoEstado, String mensaje, T datos) {
        this.codigoEstado = codigoEstado;
        this.fechaHora = OffsetDateTime.now();
        this.mensaje = mensaje;
        this.datos = datos;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public OffsetDateTime getFechaHora() {
        return fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public T getDatos() {
        return datos;
    }
}
