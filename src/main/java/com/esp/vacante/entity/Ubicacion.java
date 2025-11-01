package com.esp.vacante.entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "ubicacion_Ubicacion")
@Table(name = "ubicaciones")
public class Ubicacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Integer idUbicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_padre_ubicacion", referencedColumnName = "id_ubicacion")
    private Ubicacion idPadreUbicacion;

    @Column(name = "nombre_ubicacion", length = 150, nullable = false)
    private String nombreUbicacion;

    @Column(name = "id_dane_ubicacion", length = 30, nullable = false)
    private String idDaneUbicacion;

    @Column(name = "longitud_ubicacion", length = 30, nullable = false)
    private String logitudUbicacion;

    @Column(name = "latitud_ubicacion", length = 30, nullable = false)
    private String latitudUbicacion;

    public Ubicacion() {
    }

    public Ubicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Ubicacion(Integer idUbicacion, Ubicacion idPadreUbicacion, String nombreUbicacion,
                     String idDaneUbicacion, String logitudUbicacion, String latitudUbicacion) {
        this.idUbicacion = idUbicacion;
        this.idPadreUbicacion = idPadreUbicacion;
        this.nombreUbicacion = nombreUbicacion;
        this.idDaneUbicacion = idDaneUbicacion;
        this.logitudUbicacion = logitudUbicacion;
        this.latitudUbicacion = latitudUbicacion;
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

    public String getLogitudUbicacion() {
        return logitudUbicacion;
    }

    public void setLogitudUbicacion(String logitudUbicacion) {
        this.logitudUbicacion = logitudUbicacion;
    }

    public String getLatitudUbicacion() {
        return latitudUbicacion;
    }

    public void setLatitudUbicacion(String latitudUbicacion) {
        this.latitudUbicacion = latitudUbicacion;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ubicacion ubicacion)) return false;

        return idUbicacion.equals(ubicacion.idUbicacion) && idPadreUbicacion.equals(ubicacion.idPadreUbicacion) && nombreUbicacion.equals(ubicacion.nombreUbicacion) && idDaneUbicacion.equals(ubicacion.idDaneUbicacion) && logitudUbicacion.equals(ubicacion.logitudUbicacion) && latitudUbicacion.equals(ubicacion.latitudUbicacion);
    }

    @Override
    public int hashCode() {
        int result = idUbicacion.hashCode();
        result = 31 * result + idPadreUbicacion.hashCode();
        result = 31 * result + nombreUbicacion.hashCode();
        result = 31 * result + idDaneUbicacion.hashCode();
        result = 31 * result + logitudUbicacion.hashCode();
        result = 31 * result + latitudUbicacion.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
               "idUbicacion=" + idUbicacion +
               ", idPadreUbicacion=" + (idPadreUbicacion != null
                ? idPadreUbicacion.getIdPadreUbicacion() : "null") +
               ", nombreUbicacion='" + nombreUbicacion + '\'' +
               ", idDaneUbicacion='" + idDaneUbicacion + '\'' +
               ", logitudUbicacion='" + logitudUbicacion + '\'' +
               ", latitudUbicacion='" + latitudUbicacion + '\'' +
               '}';
    }
}
