package com.esp.area.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Table(name = "areas", indexes = {
        @Index(name = "idx_nombre_area",columnList = "nombre_area")
})
@Entity(name = "area_Area")
public class Area implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area", nullable = false)
    private Integer idArea;

    @Column(name = "nombre_area", nullable = false, unique = true, length = 150)
    private String nombreArea;

    public Area(Integer idArea) {
        this.idArea = idArea;
    }

    public Area() {
    }

    public Area(String nombreArea, Integer idArea) {
        this.nombreArea = nombreArea;
        this.idArea = idArea;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
}
