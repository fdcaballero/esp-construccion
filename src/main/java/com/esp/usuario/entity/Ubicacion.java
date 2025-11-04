package com.esp.usuario.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "usuario_Ubicacion")
@Table(name = "ubicaciones")
public class Ubicacion implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion", nullable = false)
    private Integer idUbicacion;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_padre_ubicacion", referencedColumnName = "id_ubicacion")
    private Ubicacion idPadreUbicacion;

    @Column(name = "nombre_ubicacion", nullable = false, length = 150)
    private String nombreUbicacion;

    @Column(name = "id_dane_ubicacion", nullable = false, length = 30)
    private String idDaneUbicacion;

    @Column(name = "longitud_ubicacion", nullable = false, length = 30)
    private String longitudUbicacion;

    @Column(name = "latitud_ubicacion", nullable = false, length = 30)
    private String latitudUbicacion;

    public Ubicacion() {
    }

    public Ubicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Ubicacion(Integer idUbicacion, Ubicacion idPadreUbicacion, String nombreUbicacion, String idDaneUbicacion, String longitudUbicacion, String latitudUbicacion) {
        this.idUbicacion = idUbicacion;
        this.idPadreUbicacion = idPadreUbicacion;
        this.nombreUbicacion = nombreUbicacion;
        this.idDaneUbicacion = idDaneUbicacion;
        this.longitudUbicacion = longitudUbicacion;
        this.latitudUbicacion = latitudUbicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return Objects.equals(idUbicacion, ubicacion.idUbicacion) && Objects.equals(idPadreUbicacion, ubicacion.idPadreUbicacion) && Objects.equals(nombreUbicacion, ubicacion.nombreUbicacion) && Objects.equals(idDaneUbicacion, ubicacion.idDaneUbicacion) && Objects.equals(longitudUbicacion, ubicacion.longitudUbicacion) && Objects.equals(latitudUbicacion, ubicacion.latitudUbicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUbicacion, idPadreUbicacion, nombreUbicacion, idDaneUbicacion, longitudUbicacion, latitudUbicacion);
    }

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Ubicacion getIdPadreUbicacion() {
        return idPadreUbicacion;
    }

    public void setIdPadreUbicacion(Ubicacion idPadreUbicacion) {
        this.idPadreUbicacion = idPadreUbicacion;
    }

    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public void setNombreUbicacion(String nombreUbicacion) {
        this.nombreUbicacion = nombreUbicacion;
    }

    public String getIdDaneUbicacion() {
        return idDaneUbicacion;
    }

    public void setIdDaneUbicacion(String idDaneUbicacion) {
        this.idDaneUbicacion = idDaneUbicacion;
    }

    public String getLongitudUbicacion() {
        return longitudUbicacion;
    }

    public void setLongitudUbicacion(String longitudUbicacion) {
        this.longitudUbicacion = longitudUbicacion;
    }

    public String getLatitudUbicacion() {
        return latitudUbicacion;
    }

    public void setLatitudUbicacion(String latitudUbicacion) {
        this.latitudUbicacion = latitudUbicacion;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "idUbicacion=" + idUbicacion +
                ", idPadreUbicacion=" + (idPadreUbicacion != null ? idPadreUbicacion.getIdUbicacion() : "null") +
                ", nombreUbicacion='" + nombreUbicacion + '\'' +
                ", idDaneUbicacion='" + idDaneUbicacion + '\'' +
                ", longitudUbicacion='" + longitudUbicacion + '\'' +
                ", latitudUbicacion='" + latitudUbicacion + '\'' +
                '}';
    }
}
