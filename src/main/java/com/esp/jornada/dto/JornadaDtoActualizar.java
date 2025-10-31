package com.esp.jornada.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class JornadaDtoActualizar {
    @NotNull
    private Integer idJornada;

    @Size(min = 1, max = 150)
    private String nombreJornada;

    public JornadaDtoActualizar() {
    }

    public JornadaDtoActualizar(Integer idJornada, String nombreJornada) {
        this.idJornada = idJornada;
        this.nombreJornada = nombreJornada;
    }
}