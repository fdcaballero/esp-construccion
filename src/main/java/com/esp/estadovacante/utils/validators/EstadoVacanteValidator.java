package com.esp.estadovacante.utils.validators;

import com.esp.infraestructura.exception.ExceptionValidation;

public class EstadoVacanteValidator {
    private static final  int LONGITUD = 100;

    public EstadoVacanteValidator() {
    }

    private static void validarNombreVacio(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()) {
            throw new ExceptionValidation("Nombre de estado vacante requerido");
        }
    }

    public static void validarLongitud(String nombre, int maximo) {
        if(nombre.trim().length() > maximo) {
            throw new ExceptionValidation("Longitud superada");
        }
    }

    public static void validarNombre(String nombre) {
        validarNombreVacio(nombre);
        validarLongitud(nombre, LONGITUD);
    }

    public static Short ordenAjustado(Short valororden) {
        if(valororden == null || valororden < 1 || valororden > 20) {
            return 1;
        }
        return valororden;
    }

}
