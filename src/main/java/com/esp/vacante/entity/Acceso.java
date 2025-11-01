package com.esp.vacante.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "accesos")
public class Acceso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuarios;

    @Size(max = 150)
    @NotNull
    @Column(name = "telefono_acceso", nullable = false, length = 150)
    private String telefonoAcceso;

    @Size(max = 150)
    @NotNull
    @Column(name = "correo_acceso", nullable = false, length = 150)
    private String correoAcceso;

    @NotNull
    @ColumnDefault("2")
    @Column(name = "correo_verificado_acceso", nullable = false)
    private Short correoVerificadoAcceso;

    @Size(max = 150)
    @NotNull
    @Column(name = "clave_acceso", nullable = false, length = 150)
    private String claveAcceso;

    @Size(max = 150)
    @NotNull
    @Column(name = "uuid_acceso", nullable = false, length = 150)
    private String uuidAcceso;

    @OneToMany(mappedBy = "idUsuario")
    private Set<Ingreso> ingresos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public String getTelefonoAcceso() {
        return telefonoAcceso;
    }

    public void setTelefonoAcceso(String telefonoAcceso) {
        this.telefonoAcceso = telefonoAcceso;
    }

    public String getCorreoAcceso() {
        return correoAcceso;
    }

    public void setCorreoAcceso(String correoAcceso) {
        this.correoAcceso = correoAcceso;
    }

    public Short getCorreoVerificadoAcceso() {
        return correoVerificadoAcceso;
    }

    public void setCorreoVerificadoAcceso(Short correoVerificadoAcceso) {
        this.correoVerificadoAcceso = correoVerificadoAcceso;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getUuidAcceso() {
        return uuidAcceso;
    }

    public void setUuidAcceso(String uuidAcceso) {
        this.uuidAcceso = uuidAcceso;
    }

    public Set<Ingreso> getIngresos() {
        return ingresos;
    }

    public void setIngresos(Set<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

}