package com.esp.infraestructura.utils.validators;

import com.esp.infraestructura.dto.ArchivoDtoMetadato;
import com.esp.infraestructura.exception.ExceptionValidation;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class ArchivoRegla {


    public static void verificar(
            MultipartFile archivo, List<String> tiposPermitidos, long tamanioMaximoBytes
    ) {
        if (archivo == null || archivo.isEmpty()) {
            throw new ExceptionValidation("Archivo vacío o corrupto");
        }

        if (archivo.getSize() > tamanioMaximoBytes) {
            double megas = tamanioMaximoBytes / (1024.0 * 1024.0);
            throw new ExceptionValidation("Tamaño máximo de " + megas + " megas");
        }

        String tipo = archivo.getContentType();
        if (tipo == null || !tiposPermitidos.contains(tipo.toLowerCase())) {
            throw new ExceptionValidation("Tipo de archivo: " + tipo + " , no válido");
        }
    }

    public static ArchivoDtoMetadato extraerMetadatos(MultipartFile archivo) {
        String nombrePublico = archivo.getOriginalFilename();
        String tipoMime = archivo.getContentType();
        String tamanio = String.valueOf(archivo.getSize());
        String extension = nombrePublico != null && nombrePublico.contains(".")
                ? nombrePublico.substring(nombrePublico.lastIndexOf('.'))
                : "";

        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        String uuid = UUID.randomUUID().toString();
        String nombrePrivado = fecha + "_" + uuid + "_" + nombrePublico;

        return new ArchivoDtoMetadato(nombrePublico, nombrePrivado, tipoMime, tamanio, extension);
    }


}
