package com.esp.estadovacante.entity;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "estados_vacantes")
@Entity(name = "estadovacante_EstadoVacante")
public class EstadoVacante implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_vacante")
    private Integer idEstadoVacante;


    @Column(name = "nombre_estado_vacante", nullable = false, unique = true, length = 100)
    private String nombreEstadoVacante;

    @Column(name = "orden_estado_vacante", nullable = false, unique = true)
    private Short ordenEstadoVacante;

    public EstadoVacante() {
    }

    public EstadoVacante(Integer idEstadoVacante) {
        this.idEstadoVacante = idEstadoVacante;
    }

    public EstadoVacante(Integer idEstadoVacante, String nombreEstadoVacante, Short ordenEstadoVacante) {
        this.idEstadoVacante = idEstadoVacante;
        this.nombreEstadoVacante = nombreEstadoVacante;
        this.ordenEstadoVacante = ordenEstadoVacante;
    }

    public Integer getIdEstadoVacante() {
        return idEstadoVacante;
    }

    public void setIdEstadoVacante(Integer idEstadoVacante) {
        this.idEstadoVacante = idEstadoVacante;
    }

    public String getNombreEstadoVacante() {
        return nombreEstadoVacante;
    }

    public void setNombreEstadoVacante(String nombreEstadoVacante) {
        this.nombreEstadoVacante = nombreEstadoVacante;
    }

    public Short getOrdenEstadoVacante() {
        return ordenEstadoVacante;
    }

    public void setOrdenEstadoVacante(Short ordenEstadoVacante) {
        this.ordenEstadoVacante = ordenEstadoVacante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoVacante that = (EstadoVacante) o;
        return Objects.equals(idEstadoVacante, that.idEstadoVacante);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idEstadoVacante);
    }

    @Override
    public String toString() {
        return "EstadoVacante{" +
                "idEstadoVacante=" + idEstadoVacante +
                ", nombreEstadoVacante='" + nombreEstadoVacante + '\'' +
                ", ordenEstadoVacante=" + ordenEstadoVacante +
                '}';
    }
}