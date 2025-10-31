package com.esp.modalidad.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "modalidad_Modalidad")
@Table(name = "modalidades")
public class Modalidad implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modalidad")
    private Integer idModalidad;

    @Column(name = "nombre_modalidad", nullable = false, length = 150, unique = true)
    private String nombreModalidad;


    public Modalidad() {
    }

    public Modalidad(Integer idModalidad) {
        this.idModalidad = idModalidad;
    }

    public Modalidad(Integer idModalidad, String nombreModalidad) {
        this.idModalidad = idModalidad;
        this.nombreModalidad = nombreModalidad;
    }

    public Integer getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Integer idModalidad) {
        this.idModalidad = idModalidad;
    }

    public String getNombreModalidad() {
        return nombreModalidad;
    }

    public void setNombreModalidad(String nombreModalidad) {
        this.nombreModalidad = nombreModalidad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idModalidad);
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
        final Modalidad other = (Modalidad) obj;
        return Objects.equals(this.idModalidad, other.idModalidad);
    }

    @Override
    public String toString() {
        return "Modalidad{" + "idModalidad=" + idModalidad + ", nombreModalidad=" + nombreModalidad + '}';
    }


}
