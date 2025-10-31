package com.esp.jornada.utils.validations;

import com.esp.infraestructura.exception.ExceptionValidation;

public class JornadaValidator {
    private static final int LONGITUD = 150;

    public JornadaValidator() {
    }

    private static void validarNomberVacio(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new ExceptionValidation("Nombre de la jornada es requerido");
        }
    }

    private static void validarLongitud(String nombre) {
        if (nombre.trim().length() > LONGITUD) {
            throw new ExceptionValidation("El nombre debe tener máximo 150 caracteres");
        }
    }

    public static void validarNombre(String nombre) {
        validarNomberVacio(nombre);
        validarLongitud(nombre);
    }
}
