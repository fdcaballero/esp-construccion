package com.esp.vacante.dto;

public class AnuncioDtoMetadato {
    private String nombrePublico;
    private String nombrePrivado;
    private String tipoAnuncio;
    private String tamanio;

    public AnuncioDtoMetadato() {
    }

    public AnuncioDtoMetadato(String nombrePublico, String nombrePrivado,
                              String tipoAnuncio, String tamanio) {
        this.nombrePublico = nombrePublico;
        this.nombrePrivado = nombrePrivado;
        this.tipoAnuncio = tipoAnuncio;
        this.tamanio = tamanio;
    }

    public String getNombrePublico() {
        return nombrePublico;
    }

    public void setNombrePublico(String nombrePublico) {
        this.nombrePublico = nombrePublico;
    }

    public String getNombrePrivatdo() {
        return nombrePrivado;
    }

    public void setNombrePrivatdo(String nombrePrivado) {
        this.nombrePrivado = nombrePrivado;
    }

    public String getTipoAnuncio() {
        return tipoAnuncio;
    }

    public void setTipoAnuncio(String tipoAnuncio) {
        this.tipoAnuncio = tipoAnuncio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
}
