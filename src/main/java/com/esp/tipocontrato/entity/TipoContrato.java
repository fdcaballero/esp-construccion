package com.esp.tipocontrato.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Table(name = "tipo_contratos", indexes = @Index(name = "idx_nombre_tipo_contrato",
        columnList = "nombre_tipo_contrato"))
@Entity(name = "contrato_Tipocontrato")
public class TipoContrato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato")
    private Integer idTipoContrato;

    @Column(name = "nombre_contrato", nullable = false, unique = true, length = 150)
    private String nombreTipoContrato;


    public TipoContrato() {
    }

    public TipoContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public TipoContrato(Integer idTipoContrato, String nombreTipoContrato) {
        this.idTipoContrato = idTipoContrato;
        this.nombreTipoContrato = nombreTipoContrato;
    }

    public Integer getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getNombreTipoContrato() {
        return nombreTipoContrato;
    }

    public void setNombreTipoContrato(String nombreTipoContrato) {
        this.nombreTipoContrato = nombreTipoContrato;
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
        final TipoContrato other = (TipoContrato) obj;
        return Objects.equals(this.idTipoContrato, other.idTipoContrato);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idTipoContrato);
    }

    @Override
    public String toString() {
        return "TipoEmpresa{" +
                "idTipoEmpresa=" + idTipoContrato +
                ", nombreTipoEmpresa='" + nombreTipoContrato + '\'' +
                '}';
    }
}
