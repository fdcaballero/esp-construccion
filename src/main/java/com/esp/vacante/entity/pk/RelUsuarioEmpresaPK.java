package com.esp.vacante.entity.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RelUsuarioEmpresaPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "id_empresa", nullable = false)
    private Integer idEmpresa;


    public RelUsuarioEmpresaPK() {
    }

    public RelUsuarioEmpresaPK(Integer idUsuario, Integer idEmpresa) {
        this.idUsuario = idUsuario;
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelUsuarioEmpresaPK that = (RelUsuarioEmpresaPK) o;
        return idUsuario.equals(that.idUsuario) && idEmpresa.equals(that.idEmpresa);
    }

    @Override
    public int hashCode() {
        int result = idUsuario.hashCode();
        result = 31 * result + idEmpresa.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RelUsuarioEmpresaPK{" +
               "idUsuario=" + idUsuario +
               ", idEmpresa=" + idEmpresa +
               '}';
    }
}
