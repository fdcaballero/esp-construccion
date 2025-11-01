package com.esp.infraestructura.dto;

public class ArchivoDtoMetadato {

    private final String nombrePublico;
    private final String nombrePrivado;
    private final String tipoMime;
    private final String extension;
    private final String tamanio;

    public ArchivoDtoMetadato(String nombrePublico, String nombrePrivado,
                              String tipoMime, String extension, String tamanio) {
        this.nombrePublico = nombrePublico;
        this.nombrePrivado = nombrePrivado;
        this.tipoMime = tipoMime;
        this.extension = extension;
        this.tamanio = tamanio;
    }

    public String getNombrePublico() {
        return nombrePublico;
    }

    public String getNombrePrivado() {
        return nombrePrivado;
    }

    public String getTipoMime() {
        return tipoMime;
    }

    public String getExtension() {
        return extension;
    }

    public String getTamanio() {
        return tamanio;
    }
}
