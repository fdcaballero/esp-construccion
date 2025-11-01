package com.esp.vacante.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VacanteDtoCrear {

    private String tituloVacante;
    private String detalleVacante;
    private OffsetDateTime fechaInicioVacante;
    private OffsetDateTime fechaFinVacante;
    private Short estadoVacante;
    private String minSalarioVacante;
    private String maxSalarioVacante;

    private Integer idUbicacion;
    private Integer idJornada;
    private Integer idModalidad;
    private Integer idTipoContrato;
    private Integer idUsuario;
    private Integer idEmpresa;

    private String idPalabraClaveTexto;
    private List<Integer> idPalabraClave;

    private MultipartFile archivo;


    private List<Integer> parserIdDto(String raw) {
        if (raw == null || raw.isBlank()) return Collections.emptyList();
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(raw, new TypeReference<List<Integer>>(){});
        } catch (JsonProcessingException e) {
            Logger.getLogger(VacanteDtoCrear.class.getName()).log(Level.SEVERE, null, e);
            throw new IllegalArgumentException("Formato incorrecto" + raw);
        }
    }

    public String getTituloVacante() {
        return tituloVacante;
    }

    public void setTituloVacante(String tituloVacante) {
        this.tituloVacante = tituloVacante;
    }

    public String getDetalleVacante() {
        return detalleVacante;
    }

    public void setDetalleVacante(String detalleVacante) {
        this.detalleVacante = detalleVacante;
    }

    public OffsetDateTime getFechaInicioVacante() {
        return fechaInicioVacante;
    }

    public void setFechaInicioVacante(OffsetDateTime fechaInicioVacante) {
        this.fechaInicioVacante = fechaInicioVacante;
    }

    public OffsetDateTime getFechaFinVacante() {
        return fechaFinVacante;
    }

    public void setFechaFinVacante(OffsetDateTime fechaFinVacante) {
        this.fechaFinVacante = fechaFinVacante;
    }

    public Short getEstadoVacante() {
        return estadoVacante;
    }

    public void setEstadoVacante(Short estadoVacante) {
        this.estadoVacante = estadoVacante;
    }

    public String getMinSalarioVacante() {
        return minSalarioVacante;
    }

    public void setMinSalarioVacante(String minSalarioVacante) {
        this.minSalarioVacante = minSalarioVacante;
    }

    public String getMaxSalarioVacante() {
        return maxSalarioVacante;
    }

    public void setMaxSalarioVacante(String maxSalarioVacante) {
        this.maxSalarioVacante = maxSalarioVacante;
    }

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Integer getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Integer idJornada) {
        this.idJornada = idJornada;
    }

    public Integer getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Integer idModalidad) {
        this.idModalidad = idModalidad;
    }

    public Integer getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdPalabraClaveTexto() {
        return idPalabraClaveTexto;
    }

    public void setIdPalabraClaveTexto(String idPalabraClaveTexto) {
        this.idPalabraClaveTexto = idPalabraClaveTexto;
        this.idPalabraClave = parserIdDto(idPalabraClaveTexto);
    }

    public List<Integer> getIdPalabraClave() {
        return idPalabraClave;
    }

    public void setIdPalabraClave(List<Integer> idPalabraClave) {
        this.idPalabraClave = idPalabraClave;
    }

    public MultipartFile getArchivo() {
        return archivo;
    }

    public void setArchivo(MultipartFile archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "VacanteDtoCrear{" +
               "tituloVacante='" + tituloVacante + '\'' +
               ", detalleVacante='" + detalleVacante + '\'' +
               ", fechaInicioVacante=" + fechaInicioVacante +
               ", fechaFinVacante=" + fechaFinVacante +
               ", estadoVacante=" + estadoVacante +
               ", minSalarioVacante='" + minSalarioVacante + '\'' +
               ", maxSalarioVacante='" + maxSalarioVacante + '\'' +
               ", idUbicacion=" + idUbicacion +
               ", idJornada=" + idJornada +
               ", idModalidad=" + idModalidad +
               ", idTipoContrato=" + idTipoContrato +
               ", idUsuario=" + idUsuario +
               ", idEmpresa=" + idEmpresa +
               ", idPalabraClaveTexto='" + idPalabraClaveTexto + '\'' +
               ", idPalabraClave=" + idPalabraClave +
               ", archivo=" + archivo +
               '}';
    }
}
