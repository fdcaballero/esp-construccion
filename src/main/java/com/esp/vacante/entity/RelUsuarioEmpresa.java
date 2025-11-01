package com.esp.vacante.entity;


import com.esp.vacante.entity.pk.RelUsuarioEmpresaPK;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "vacante_RelUsuarioEmpresa")
@Table(name = "rel_usuarios_empresas",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_usuario", "id_empresa"}))
public class RelUsuarioEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private RelUsuarioEmpresaPK id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario",nullable = false,
            insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", nullable = false,
            insertable = false, updatable = false)
    private Empresa empresa;

    @Column(name = "permiso_rel_usuario_empresa")
    private Short permisoRelUsuarioEmpresa;

    public RelUsuarioEmpresa() {
    }

    public RelUsuarioEmpresa(RelUsuarioEmpresaPK id) {
        this.id = id;
    }

    public RelUsuarioEmpresa(Short permisoRelUsuarioEmpresa, RelUsuarioEmpresaPK id) {
        this.permisoRelUsuarioEmpresa = permisoRelUsuarioEmpresa;
        this.id = id;
    }

    public RelUsuarioEmpresa(Integer idUsuario, Integer idEmpresa) {
        this.id = new RelUsuarioEmpresaPK(idUsuario, idEmpresa);
    }

    public RelUsuarioEmpresa(Integer idUsuario, Integer idEmpresa,Short permisoRelUsuarioEmpresa) {
        this.id = new RelUsuarioEmpresaPK(idUsuario, idEmpresa);
        this.permisoRelUsuarioEmpresa = permisoRelUsuarioEmpresa;
    }

    public RelUsuarioEmpresaPK getId() {
        return id;
    }

    public void setId(RelUsuarioEmpresaPK id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Short getPermisoRelUsuarioEmpresa() {
        return permisoRelUsuarioEmpresa;
    }

    public void setPermisoRelUsuarioEmpresa(Short permisoRelUsuarioEmpresa) {
        this.permisoRelUsuarioEmpresa = permisoRelUsuarioEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelUsuarioEmpresa that = (RelUsuarioEmpresa) o;
        return id.equals(that.id) && usuario.equals(that.usuario) && empresa.equals(that.empresa) && permisoRelUsuarioEmpresa.equals(that.permisoRelUsuarioEmpresa);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + usuario.hashCode();
        result = 31 * result + empresa.hashCode();
        result = 31 * result + permisoRelUsuarioEmpresa.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RelUsuarioEmpresa{" +
               "id=" + id +
               ", usuario=" + usuario +
               ", empresa=" + empresa +
               ", permisoRelUsuarioEmpresa=" + permisoRelUsuarioEmpresa +
               '}';
    }
}
