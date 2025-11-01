package com.esp.vacante.entity.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InteresPk implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_empresa", nullable = false)
    private Integer idEmpresa;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    public InteresPk() {
    }

    public InteresPk(Integer idEmpresa, Integer idUsuario) {
        this.idEmpresa = idEmpresa;
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InteresPk interesPk = (InteresPk) o;
        return idEmpresa.equals(interesPk.idEmpresa) && idUsuario.equals(interesPk.idUsuario);
    }

    @Override
    public int hashCode() {
        int result = idEmpresa.hashCode();
        result = 31 * result + idUsuario.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "InteresPk{" +
               "idEmpresa=" + idEmpresa +
               ", idUsuario=" + idUsuario +
               '}';
    }
}
