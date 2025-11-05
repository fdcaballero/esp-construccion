package com.esp.usuario.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;


public class UsuarioDtoCrear implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "El id debe ser nulo")
    private Short tipoDocumento;

    @NotNull(message = "El documento no debe ser nulo")
    @Size(min = 1, max = 150, message = "El documento debe tener entre 1 y 150 caracteres")
    private String documentoUsuario;

    @NotNull(message = "El nombre no debe ser nulo")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    private String nombresUsuario;
    @NotNull(message = "Los apellidos no debe ser nulo")
    @Size(min = 1, max = 50, message = "Los apellidos debe tener entre 1 y 50 caracteres")
    private String apellidosUsuario;

    @NotNull(message = "El estado no debe ser nulo")
    private Short estadoUsuario;

    @NotNull(message = "La ubicacion no debe ser nulo")
    private Integer idUbicacion;

    @NotNull(message = "El archivo no debe ser nulo")
    private MultipartFile archivo;

    @NotNull(message = "El campo favoritaImagen es requerido")
    private Short favoritaImagen;

    public UsuarioDtoCrear() {
    }

    public UsuarioDtoCrear(Short tipoDocumento, String documetoUsuario, String nombresUsuario,
                           String apellidosUsuario, Short estadoUsuario, Integer idUbicacion,
                           MultipartFile archivo, Short favoritaImagen) {
        this.tipoDocumento = tipoDocumento;
        this.documentoUsuario = documetoUsuario;
        this.nombresUsuario = nombresUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.estadoUsuario = estadoUsuario;
        this.idUbicacion = idUbicacion;
        this.archivo = archivo;
        this.favoritaImagen = favoritaImagen;
    }

    public Short getFavoritaImagen() {
        return favoritaImagen;
    }

    public void setFavoritaImagen(Short favoritaImagen) {
        this.favoritaImagen = favoritaImagen;
    }

    public Short getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Short tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documetoUsuario) {
        this.documentoUsuario = documetoUsuario;
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

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public MultipartFile getArchivo() {
        return archivo;
    }

    public void setArchivo(MultipartFile archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "UsuarioDtoCrear{" +
                "tipoDocumento=" + tipoDocumento +
                ", documentoUsuario='" + documentoUsuario + '\'' +
                ", nombresUsuario='" + nombresUsuario + '\'' +
                ", apellidosUsuario='" + apellidosUsuario + '\'' +
                ", estadoUsuario=" + estadoUsuario +
                ", idUbicacion=" + idUbicacion +
                ", favoritaImagen=" + favoritaImagen +
                '}';
    }
}
