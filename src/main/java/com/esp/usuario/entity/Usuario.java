package com.esp.usuario.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "usuario_Usuario")
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion")
    private Ubicacion ubicacion;

    @Column(name = "tipo_documento_usuario", nullable = false)
    private Short tipoDocumentoUsuario;

    @Column(name = "documento_usuario", nullable = false, length = 150)
    private String documentoUsuario;

    @Column(name = "nombres_usuario", nullable = false, length = 50)
    private String nombresUsuario;

    @Column(name = "apellidos_usuario", nullable = false, length = 50)
    private String apellidosUsuario;

    @Column(name = "estado_usuario", nullable = false)
    private Short estadoUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, Ubicacion ubicacion, Short tipoDocumentoUsuario, String documentoUsuario, String nombresUsuario, String apellidosUsuario, Short estadoUsuario) {
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(ubicacion, usuario.ubicacion) &&
                Objects.equals(tipoDocumentoUsuario, usuario.tipoDocumentoUsuario) &&
                Objects.equals(documentoUsuario, usuario.documentoUsuario) &&
                Objects.equals(nombresUsuario, usuario.nombresUsuario) &&
                Objects.equals(apellidosUsuario, usuario.apellidosUsuario) &&
                Objects.equals(estadoUsuario, usuario.estadoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, ubicacion, tipoDocumentoUsuario, documentoUsuario,
                nombresUsuario, apellidosUsuario, estadoUsuario);
    }
}
