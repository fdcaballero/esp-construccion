package com.esp.empresa.utils.validation;

import com.esp.infraestructura.exception.ExceptionValidation;

public class TipoEmpresaValidator {

    private static final int LONGITUD = 150;

    public TipoEmpresaValidator() {
    }

    private static void validateNombreisEmpty(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new ExceptionValidation("El nombre del tipo de empresa no puede ser nulo o vacío");
    }

    private static void validateNombreLength(String nombre, int maximo) {
        if (nombre.trim().length() > maximo)
            throw new ExceptionValidation("El nombre del tipo de empresa no puede exceder los " + LONGITUD + " caracteres");
    }

    public static void validateNombre(String nombre) {
        validateNombreisEmpty(nombre);
        validateNombreLength(nombre, LONGITUD);
    }

    public static Short estadoAjustado(Short estado) {
        if (estado == null || estado < 1 || estado > 3)
            return 1;
        return estado;
    }
}
