package com.esp.tipocontrato.utils.validators;

import com.esp.infraestructura.exception.ExceptionValidation;

public class TipoContratoValidator {

    private static final int LONGITUD = 150;

    public TipoContratoValidator() {
    }

    private static void validarNombreVacio(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ExceptionValidation("Nombre tipo de contrato requerido");
        }
    }

    public static void validarLongitud(String nombre, int maximo) {
        if (nombre.trim().length() > maximo) {
            throw new ExceptionValidation("Longitud superada");
        }
    }

    public static void validarNombre(String nombre) {
        validarNombreVacio(nombre);
        validarLongitud(nombre, LONGITUD);
    }
}
