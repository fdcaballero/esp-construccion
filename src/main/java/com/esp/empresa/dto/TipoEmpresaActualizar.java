package com.esp.empresa.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TipoEmpresaActualizar {

    @NotNull
    private Integer idTipoEmpresa;

    @Size(min = 1, max = 150)
    @NotNull
    private String nombreTipoEmpresa;

    private Short estadoTipoEmpresa;


    public TipoEmpresaActualizar() {
    }

    public TipoEmpresaActualizar(Integer idTipoEmpresa, String nombreTipoEmpresa, Short estadoTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
        this.nombreTipoEmpresa = nombreTipoEmpresa;
        this.estadoTipoEmpresa = estadoTipoEmpresa;
    }

    public @NotNull Integer getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(@NotNull Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public @Size(min = 1, max = 150) @NotNull String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public void setNombreTipoEmpresa(@Size(min = 1, max = 150) @NotNull String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

    public Short getEstadoTipoEmpresa() {
        return estadoTipoEmpresa;
    }

    public void setEstadoTipoEmpresa(Short estadoTipoEmpresa) {
        this.estadoTipoEmpresa = estadoTipoEmpresa;
    }
}
