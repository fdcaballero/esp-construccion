package com.esp.jornada.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Table(name = "jornadas")
@Entity(name = "jornada_Jornada")
public class Jornada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jornada")
    private Integer idJornada;

    @Column(name = "nombre_jornada", nullable = false, length = 150, unique = true)
    private String nombreJornada;

    public Jornada() {
    }

    public Jornada(Integer idJornada) {
        this.idJornada = idJornada;
    }

    public Jornada(Integer idJornada, String nombreJornada) {
        this.idJornada = idJornada;
        this.nombreJornada = nombreJornada;
    }

    public Integer getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Integer idJornada) {
        this.idJornada = idJornada;
    }

    public String getNombreJornada() {
        return nombreJornada;
    }

    public void setNombreJornada(String nombreJornada) {
        this.nombreJornada = nombreJornada;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idJornada);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jornada other = (Jornada) obj;
        return Objects.equals(this.idJornada, other.idJornada);
    }

}
