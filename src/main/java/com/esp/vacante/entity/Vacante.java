package com.esp.vacante.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity(name = "vacante_Vacante")
@Table(name = "vacantes")
public class Vacante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacante", nullable = false, unique = true)
    private Integer idVacante;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion")
    private Ubicacion idUbicacion;

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"),
            @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    })
    private RelUsuarioEmpresa idRelUsuarioEmpresa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_jornada", referencedColumnName = "id_jornada")
    private Jornada idJornada;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_modalidad", referencedColumnName = "id_modalidad")
    private Modalidad idModalidad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo_contrato", referencedColumnName = "id_tipo_contrato")
    private TipoContrato idTipoContrato;

    @Column(name = "titulo_vacante", length = 300, nullable = false)
    private String tituloVacante;

    @Lob
    @Column(name = "detalle_vacante", nullable = false)
    private String detalleVacante;

    @Column(name = "fecha_inicio_vacante", nullable = false)
    private OffsetDateTime fechaInicioVacante;

    @Column(name = "fecha_fin_vacante", nullable = false)
    private OffsetDateTime fechaFinVacante;

    @Column(name = "estado_vacante", nullable = false)
    private Short estadoVacante;

    @Column(name = "min_salario_vacante", nullable = false, length = 100)
    private String minSalarioVacante;

    @Column(name = "max_salario_vacante", nullable = false, length = 100)
    private String maxSalarioVacante;

    public Vacante() {
    }

    public Vacante(Integer idVacante) {
        this.idVacante = idVacante;
    }

    public Integer getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(Integer idVacante) {
        this.idVacante = idVacante;
    }

    public Ubicacion getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Ubicacion idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public RelUsuarioEmpresa getIdRelUsuarioEmpresa() {
        return idRelUsuarioEmpresa;
    }

    public void setIdRelUsuarioEmpresa(RelUsuarioEmpresa idRelUsuarioEmpresa) {
        this.idRelUsuarioEmpresa = idRelUsuarioEmpresa;
    }

    public Jornada getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Jornada idJornada) {
        this.idJornada = idJornada;
    }

    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Modalidad idModalidad) {
        this.idModalidad = idModalidad;
    }

    public TipoContrato getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(TipoContrato idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacante vacante = (Vacante) o;
        return idVacante.equals(vacante.idVacante) && idUbicacion.equals(vacante.idUbicacion) && idRelUsuarioEmpresa.equals(vacante.idRelUsuarioEmpresa) && idJornada.equals(vacante.idJornada) && idModalidad.equals(vacante.idModalidad) && idTipoContrato.equals(vacante.idTipoContrato) && tituloVacante.equals(vacante.tituloVacante) && detalleVacante.equals(vacante.detalleVacante) && fechaInicioVacante.equals(vacante.fechaInicioVacante) && fechaFinVacante.equals(vacante.fechaFinVacante) && estadoVacante.equals(vacante.estadoVacante) && minSalarioVacante.equals(vacante.minSalarioVacante) && maxSalarioVacante.equals(vacante.maxSalarioVacante);
    }

    @Override
    public int hashCode() {
        int result = idVacante.hashCode();
        result = 31 * result + idUbicacion.hashCode();
        result = 31 * result + idRelUsuarioEmpresa.hashCode();
        result = 31 * result + idJornada.hashCode();
        result = 31 * result + idModalidad.hashCode();
        result = 31 * result + idTipoContrato.hashCode();
        result = 31 * result + tituloVacante.hashCode();
        result = 31 * result + detalleVacante.hashCode();
        result = 31 * result + fechaInicioVacante.hashCode();
        result = 31 * result + fechaFinVacante.hashCode();
        result = 31 * result + estadoVacante.hashCode();
        result = 31 * result + minSalarioVacante.hashCode();
        result = 31 * result + maxSalarioVacante.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Vacante{" +
               "idVacante=" + idVacante +
               ", idUbicacion=" + idUbicacion +
               ", idRelUsuarioEmpresa=" + idRelUsuarioEmpresa +
               ", idJornada=" + idJornada +
               ", idModalidad=" + idModalidad +
               ", idTipoContrato=" + idTipoContrato +
               ", tituloVacante='" + tituloVacante + '\'' +
               ", detalleVacante='" + detalleVacante + '\'' +
               ", fechaInicioVacante=" + fechaInicioVacante +
               ", fechaFinVacante=" + fechaFinVacante +
               ", estadoVacante=" + estadoVacante +
               ", minSalarioVacante='" + minSalarioVacante + '\'' +
               ", maxSalarioVacante='" + maxSalarioVacante + '\'' +
               '}';
    }
}
