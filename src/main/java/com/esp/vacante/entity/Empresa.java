package com.esp.vacante.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "vacante_Empresa")
@Table(name = "empresas")
public class Empresa implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer idEmpresa;


    @JoinColumn(name = "id_tipo_empresa", nullable = false,
            referencedColumnName = "id_tipo_empresa",
            foreignKey = @ForeignKey(name = "fk_empresas_ref_tipoempre"))
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private TipoEmpresa idTipoEmpresa;

    @Column(name = "nombre_empresa", nullable = false, length = 200)
    private String nombreEmpresa;

    @Column(name = "direccion_empresa", length = 200, nullable = false)
    private String direccionEmpresa;

    @Column(name = "telefono_empresa", length = 200, nullable = false)
    private String telefonoEmpresa;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, TipoEmpresa idTipoEmpresa, String nombreEmpresa, String direccionEmpresa, String telefonoEmpresa) {
        this.idEmpresa = idEmpresa;
        this.idTipoEmpresa = idTipoEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa empresa)) return false;

        return idEmpresa.equals(empresa.idEmpresa);
    }

    @Override
    public int hashCode() {
        return idEmpresa.hashCode();
    }

    @Override
    public String toString() {
        return "Empresa {" +
               "idEmpresa=" + idEmpresa +
               ", idTipoEmpresa=" + (idTipoEmpresa != null ? idTipoEmpresa.getIdTipoEmpresa() : "null") +
               ", nombreEmpresa='" + nombreEmpresa + '\'' +
               ", direccionEmpresa='" + direccionEmpresa + '\'' +
               ", telefonoEmpresa='" + telefonoEmpresa + '\'' +
               '}';
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public TipoEmpresa getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(TipoEmpresa idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }
}
