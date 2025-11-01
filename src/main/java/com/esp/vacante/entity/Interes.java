package com.esp.vacante.entity;

import com.esp.vacante.entity.pk.InteresPk;
import jakarta.persistence.*;

@Entity(name = "vacante_InteresPk")
@Table(name = "intereses")
public class Interes {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected InteresPk id;

    @MapsId("idEmpresa")
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa",
            updatable = false, nullable = false, insertable = false)
    private Empresa empresa;

    @MapsId("idUsuario")
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario",
            updatable = false, nullable = false, insertable = false)
    private Usuario usuario;

    @Column(name = "tipo_interes", nullable = false)
    private Short tipoInteres;

    public Interes() {
    }

    public Interes(InteresPk id) {
        this.id = id;
    }

    public Interes(InteresPk id, Short tipoInteres) {
        this.id = id;
        this.tipoInteres = tipoInteres;
    }

    public Interes(Integer idEmpresa, Integer idUsuario) {
        this.id = new InteresPk(idEmpresa, idUsuario);
    }

    public Interes(InteresPk id, Empresa empresa, Usuario usuario, Short tipoInteres) {
        this.id = id;
        this.empresa = empresa;
        this.usuario = usuario;
        this.tipoInteres = tipoInteres;
    }

    public InteresPk getId() {
        return id;
    }

    public void setId(InteresPk id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Short getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(Short tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interes interes = (Interes) o;
        return id.equals(interes.id) && empresa.equals(interes.empresa) && usuario.equals(interes.usuario) && tipoInteres.equals(interes.tipoInteres);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + empresa.hashCode();
        result = 31 * result + usuario.hashCode();
        result = 31 * result + tipoInteres.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Interes{" +
               "id=" + id +
               ", empresa=" + empresa +
               ", usuario=" + usuario +
               ", tipoInteres=" + tipoInteres +
               '}';
    }
}
