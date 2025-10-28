package com.esp.rol.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "rol_Roles")
@Table(name = "roles", indexes = @Index(name = "idx_nombre_unico",
        columnList = "nombre_rol"))
public class Rol implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_rol", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(name = "nombre_rol", length = 150, nullable = false,
            unique = true)
    private String nombreRol;

    @Column(name = "estado_rol", nullable = false)
    private Short estadoRol;


    public Rol(Integer idRol, String nombreRol, Short estadoRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.estadoRol = estadoRol;
    }

    public Rol() {
    }

    public Rol(Integer idRol) {
        this.idRol = idRol;
    }

    public Rol( String nombreRol, Short estadoRol) {
        this.nombreRol = nombreRol;
        this.estadoRol = estadoRol;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rol rol)) return false;

        return idRol.equals(rol.idRol) && nombreRol.equals(rol.nombreRol);
    }

    @Override
    public int hashCode() {
        int result = idRol.hashCode();
        result = 31 * result + nombreRol.hashCode();
        return result;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Short getEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(Short estadoRol) {
        this.estadoRol = estadoRol;
    }
}
