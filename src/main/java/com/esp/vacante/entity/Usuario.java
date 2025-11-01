package com.esp.vacante.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Table(name = "usuarios")
@Entity(name = "vacante_Usuario")
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Ubicacion ubicacion;

    @Column(name = "tipo_documento_usuario", nullable = false)
    private Short tipoDocumentoUsuario;

    @Column(name = "documento_usuario", length = 150, nullable = false, unique = true)
    private String documentoUsuario;

    @Column(name = "nombres_usuario", length = 50, nullable = false)
    private String nombresUsuario;

    @Column(name = "apellidos_usuario", length = 50, nullable = false)
    private String apellidosUsuario;

    @Column(name = "estado_usuario", nullable = false)
    private Short estadoUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, Ubicacion ubicacion, Short tipoDocumentoUsuario, String documentoUsuario,
                   String nombresUsuario, String apellidosUsuario, Short estadoUsuario) {
        this.idUsuario = idUsuario;
        this.ubicacion = ubicacion;
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
        this.documentoUsuario = documentoUsuario;
        this.nombresUsuario = nombresUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.estadoUsuario = estadoUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Short getTipoDocumentoUsuario() {
        return tipoDocumentoUsuario;
    }

    public void setTipoDocumentoUsuario(Short tipoDocumentoUsuario) {
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public Short getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Short estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;

        return idUsuario.equals(usuario.idUsuario) && ubicacion.equals(usuario.ubicacion) && tipoDocumentoUsuario.equals(usuario.tipoDocumentoUsuario) && documentoUsuario.equals(usuario.documentoUsuario) && nombresUsuario.equals(usuario.nombresUsuario) && apellidosUsuario.equals(usuario.apellidosUsuario) && estadoUsuario.equals(usuario.estadoUsuario);
    }

    @Override
    public int hashCode() {
        int result = idUsuario.hashCode();
        result = 31 * result + ubicacion.hashCode();
        result = 31 * result + tipoDocumentoUsuario.hashCode();
        result = 31 * result + documentoUsuario.hashCode();
        result = 31 * result + nombresUsuario.hashCode();
        result = 31 * result + apellidosUsuario.hashCode();
        result = 31 * result + estadoUsuario.hashCode();
        return result;
    }
}

