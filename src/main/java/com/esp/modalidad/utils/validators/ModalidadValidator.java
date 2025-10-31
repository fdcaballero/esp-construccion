package com.esp.modalidad.utils.validators;

import com.esp.infraestructura.exception.ExceptionValidation;

public class ModalidadValidator {

    private static final int LONGITUD = 150;

    public ModalidadValidator() {
    }

    private static void validateNombreisEmpty(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new ExceptionValidation("El nombre de la Modalidad no puede ser nulo o vacío");
    }

    private static void validateNombreLength(String nombre, int maximo) {
        if (nombre.trim().length() > maximo)
            throw new ExceptionValidation("El nombre de la modalidad no puede exceder los " + LONGITUD + " caracteres");
    }

    public static void validateNombre(String nombre) {
        validateNombreisEmpty(nombre);
        validateNombreLength(nombre, LONGITUD);
    }
}
