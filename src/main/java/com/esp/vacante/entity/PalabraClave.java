package com.esp.vacante.entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Table(name = "palabras_claves",indexes = {
        @Index(name = "idx_texto_palabra_clave",
                columnList = "texto_palabra_clave")
})
@Entity(name = "vacante_PalabraClave")
public class PalabraClave implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_palabra_clave")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPalabraClave;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    private Area idArea;

    @Column(name = "texto_palabra_clave", length = 150, nullable = false, unique = true)
    private String textoPalabraClave;


    public PalabraClave() {
    }

    public PalabraClave(Integer idPalabraClave) {
        this.idPalabraClave = idPalabraClave;
    }

    public PalabraClave(Integer idPalabraClave, Area idArea, String textoPalabraClave) {
        this.idPalabraClave = idPalabraClave;
        this.idArea = idArea;
        this.textoPalabraClave = textoPalabraClave;
    }

    public Integer getIdPalabraClave() {
        return idPalabraClave;
    }

    public void setIdPalabraClave(Integer idPalabraClave) {
        this.idPalabraClave = idPalabraClave;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public String getTextoPalabraClave() {
        return textoPalabraClave;
    }

    public void setTextoPalabraClave(String textoPalabraClave) {
        this.textoPalabraClave = textoPalabraClave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PalabraClave that = (PalabraClave) o;
        return idPalabraClave.equals(that.idPalabraClave) && idArea.equals(that.idArea) && textoPalabraClave.equals(that.textoPalabraClave);
    }

    @Override
    public int hashCode() {
        int result = idPalabraClave.hashCode();
        result = 31 * result + idArea.hashCode();
        result = 31 * result + textoPalabraClave.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PalabraClave{" +
               "idPalabraClave=" + idPalabraClave +
               ", idArea=" + idArea +
               ", textoPalabraClave='" + textoPalabraClave + '\'' +
               '}';
    }
}
