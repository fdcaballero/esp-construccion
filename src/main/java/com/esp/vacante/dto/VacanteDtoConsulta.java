package com.esp.vacante.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class VacanteDtoConsulta {

    private final Integer idVacante;
    private final String tituloVacante;
    private final String detalleVacante;

    private final OffsetDateTime fechaInicioVacante;
    private final OffsetDateTime fechaFinVacante;

    private final String minSalarioVacante;
    private final String  maxSalarioVacante;

    private final String nombreUbicacion;
    private final String nombreEmpresa;
    private final String nombreJornada;
    private final String modalidad;
    private final String tipoContrato;
    private final String imagenUrl;
    private final String nombrePrivadoAnuncio;
    private final String estadoVacante;
    private final List<String> palabraClave;

    public VacanteDtoConsulta(Integer idVacante, String tituloVacante, String detalleVacante,
                              OffsetDateTime fechaInicioVacante, OffsetDateTime fechaFinVacante,
                              String minSalarioVacante, String maxSalarioVacante, String nombreUbicacion,
                              String nombreEmpresa, String nombreJornada,
                              String modalidad, String tipoContrato, String imagenUrl,
                              String nombrePrivadoAnuncio, String estadoVacante, List<String> palabraClave) {
        this.idVacante = idVacante;
        this.tituloVacante = tituloVacante;
        this.detalleVacante = detalleVacante;
        this.fechaInicioVacante = fechaInicioVacante;
        this.fechaFinVacante = fechaFinVacante;
        this.minSalarioVacante = minSalarioVacante;
        this.maxSalarioVacante = maxSalarioVacante;
        this.nombreUbicacion = nombreUbicacion;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreJornada = nombreJornada;
        this.modalidad = modalidad;
        this.tipoContrato = tipoContrato;
        this.imagenUrl = imagenUrl;
        this.nombrePrivadoAnuncio = nombrePrivadoAnuncio;
        this.estadoVacante = estadoVacante;
        this.palabraClave = palabraClave;
    }

    public VacanteDtoConsulta(Integer idVacante, String tituloVacante, String detalleVacante,
                              OffsetDateTime fechaInicioVacante, OffsetDateTime fechaFinVacante,
                              String minSalarioVacante, String maxSalarioVacante, String nombreUbicacion,
                              String nombreEmpresa, String nombreJornada,
                              String modalidad, String tipoContrato,
                              String nombrePrivadoAnuncio, String estadoVacante, List<String> palabraClave) {

        this(idVacante, tituloVacante, detalleVacante, fechaInicioVacante, fechaFinVacante,
                minSalarioVacante, maxSalarioVacante, nombreUbicacion,
                nombreEmpresa, nombreJornada, modalidad, tipoContrato,
                null, nombrePrivadoAnuncio, estadoVacante, palabraClave);
    }

    public Integer getIdVacante() {
        return idVacante;
    }

    public String getTituloVacante() {
        return tituloVacante;
    }

    public String getDetalleVacante() {
        return detalleVacante;
    }

    public OffsetDateTime getFechaInicioVacante() {
        return fechaInicioVacante;
    }

    public OffsetDateTime getFechaFinVacante() {
        return fechaFinVacante;
    }

    public String getMinSalarioVacante() {
        return minSalarioVacante;
    }

    public String getMaxSalarioVacante() {
        return maxSalarioVacante;
    }

    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNombreJornada() {
        return nombreJornada;
    }

    public String getModalidad() {
        return modalidad;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public String getNombrePrivadoAnuncio() {
        return nombrePrivadoAnuncio;
    }

    public String getEstadoVacante() {
        return estadoVacante;
    }

    public List<String> getPalabraClave() {
        return palabraClave;
    }

    public VacanteDtoConsulta conUrl(String url) {

        return new VacanteDtoConsulta(idVacante, tituloVacante, detalleVacante, fechaInicioVacante, fechaFinVacante,
                minSalarioVacante, maxSalarioVacante, nombreUbicacion,
                nombreEmpresa, nombreJornada, modalidad, tipoContrato,
                url, nombrePrivadoAnuncio, estadoVacante, palabraClave);
    }
}
