package com.esp.empresa.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;


@Entity(name = "empresa_TipoEmpresa")
@Table(name = "tipo_empresas",
        indexes = @Index(name = "idx_nombre_tipo_empresa",
                columnList = "nombre_tipo_empresa"))
public class TipoEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_empresa", nullable = false)
    private Integer idTipoEmpresa;


    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_tipo_empresa", length = 150, nullable = false, unique = true)
    private String nombreTipoEmpresa;

    @NotNull
    @Column(name = "estado_tipo_empresa", nullable = false)
    private Short estadoTipoEmpresa;

    public TipoEmpresa() {
    }

    public TipoEmpresa(Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public TipoEmpresa(Integer idTipoEmpresa, String nombreTipoEmpresa, Short estadoTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
        this.nombreTipoEmpresa = nombreTipoEmpresa;
        this.estadoTipoEmpresa = estadoTipoEmpresa;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoEmpresa that)) return false;

        return idTipoEmpresa.equals(that.idTipoEmpresa) && nombreTipoEmpresa.equals(that.nombreTipoEmpresa) && estadoTipoEmpresa.equals(that.estadoTipoEmpresa);
    }

    @Override
    public int hashCode() {
        int result = idTipoEmpresa.hashCode();
        result = 31 * result + nombreTipoEmpresa.hashCode();
        result = 31 * result + estadoTipoEmpresa.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TipoEmpresa{" +
               "idTipoEmpresa=" + idTipoEmpresa +
               ", nombreTipoEmpresa='" + nombreTipoEmpresa + '\'' +
               ", estadoTipoEmpresa=" + estadoTipoEmpresa +
               '}';
    }

    public Integer getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public @NotNull @Size(min = 1, max = 150) String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public void setNombreTipoEmpresa(@NotNull @Size(min = 1, max = 150) String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

    public @NotNull Short getEstadoTipoEmpresa() {
        return estadoTipoEmpresa;
    }

    public void setEstadoTipoEmpresa(@NotNull Short estadoTipoEmpresa) {
        this.estadoTipoEmpresa = estadoTipoEmpresa;
    }
}
