package com.esp.area.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AreaDtoActualizar {

    @NotNull
    private Integer idArea;

    @Size(min = 1, max = 150)
    private String nombreArea;

    public AreaDtoActualizar() {}
    public AreaDtoActualizar(Integer idArea, String nombreArea) {
        this.idArea = idArea;
        this.nombreArea = nombreArea;
    }

    public Integer getIdArea() { return idArea; }
    public void setIdArea(Integer idArea) { this.idArea = idArea; }

    public String getNombreArea() { return nombreArea; }
    public void setNombreArea(String nombreArea) { this.nombreArea = nombreArea; }
}