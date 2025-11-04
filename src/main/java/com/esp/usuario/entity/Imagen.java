package com.esp.usuario.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "usuario_Imagen")
@Table(name = "imagenes")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen", nullable = false)
    private Integer idImagen;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario idUsuario;

    @Column(name = "nombre_publico_imagen", nullable = false, length = 200)
    private String nombrePublico;

    @Column(name = "nombre_privado_imagen", nullable = false, length = 200)
    private String nombrePrivado;

    @Column(name = "tipo_imagen", nullable = false, length = 50)
    private String tipoImagen;

    @Column(name = "tamanio_imagen", nullable = false, length = 50)
    private String tamanioImagen;

    @Column(name = "favorita_imagen", nullable = false)
    private Short favoritaImagen;

    public Imagen() {
    }

    public Imagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Imagen(Integer idImagen, Usuario idUsuario, String nombrePublico,
                  String nombrePrivado, String tipoImagen, String tamanioImagen, Short favoritaImagen) {
        this.idImagen = idImagen;
        this.idUsuario = idUsuario;
        this.nombrePublico = nombrePublico;
        this.nombrePrivado = nombrePrivado;
        this.tipoImagen = tipoImagen;
        this.tamanioImagen = tamanioImagen;
        this.favoritaImagen = favoritaImagen;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombrePublico() {
        return nombrePublico;
    }

    public void setNombrePublico(String nombrePublico) {
        this.nombrePublico = nombrePublico;
    }

    public String getNombrePrivado() {
        return nombrePrivado;
    }

    public void setNombrePrivado(String nombrePrivado) {
        this.nombrePrivado = nombrePrivado;
    }

    public String getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(String tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    public String getTamanioImagen() {
        return tamanioImagen;
    }

    public void setTamanioImagen(String tamanioImagen) {
        this.tamanioImagen = tamanioImagen;
    }

    public Short getFavoritaImagen() {
        return favoritaImagen;
    }

    public void setFavoritaImagen(Short favoritaImagen) {
        this.favoritaImagen = favoritaImagen;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Imagen imagen = (Imagen) o;
        return Objects.equals(idImagen, imagen.idImagen) &&
                Objects.equals(idUsuario, imagen.idUsuario) &&
                Objects.equals(nombrePublico, imagen.nombrePublico) &&
                Objects.equals(nombrePrivado, imagen.nombrePrivado) &&
                Objects.equals(tipoImagen, imagen.tipoImagen) &&
                Objects.equals(tamanioImagen, imagen.tamanioImagen) &&
                Objects.equals(favoritaImagen, imagen.favoritaImagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idImagen, idUsuario, nombrePublico, nombrePrivado,
                tipoImagen, tamanioImagen, favoritaImagen);
    }

    @Override
    public String toString() {
        return "Imagen{" +
                "idImagen=" + idImagen +
                ", idUsuario=" + (idUsuario != null ? idUsuario.getNombresUsuario() : "null") +
                ", nombrePublico='" + nombrePublico + '\'' +
                ", nombrePrivado='" + nombrePrivado + '\'' +
                ", tipoImagen='" + tipoImagen + '\'' +
                ", tamanioImagen='" + tamanioImagen + '\'' +
                ", favoritaImagen=" + favoritaImagen +
                '}';
    }
}
