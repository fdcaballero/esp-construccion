package com.esp.infraestructura.utils.archivo;

import com.esp.infraestructura.constants.ConstTipoArchivo;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;

@Component
public class GestorArchivoAdmin {

    private final RutaArchivo rutaArchivo;


    public GestorArchivoAdmin(RutaArchivo rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }


    public GestorArchivoInstancia crear(ConstTipoArchivo tipo,
                                        String nombreArchivo,
                                        String respaldo,
                                        MultipartFile file) {
        String rutaBase = switch (tipo) {
            case DOCUMENTO -> rutaArchivo.getDocumentos();
            case COMPRIMIDO -> rutaArchivo.getComprimidos();
            case IMAGEN_VACANTE -> rutaArchivo.getImagenesVacantes();
            default -> rutaArchivo.getImagenes();
        };
        return new GestorArchivoInstancia(Paths.get(rutaBase),
                nombreArchivo, respaldo, file);
    }
}
