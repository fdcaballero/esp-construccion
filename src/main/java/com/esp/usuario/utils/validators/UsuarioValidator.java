package com.esp.usuario.utils.validators;

import com.esp.infraestructura.exception.ExceptionValidation;

public class UsuarioValidator {


    private static void validateFieldisEmpty(String nombre, String field) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new ExceptionValidation("El campo '%s' no puede ser nulo o vacío".formatted(field));
    }

    private static void validateNombreLength(String nombre, int maximo, String field) {
        if (nombre.trim().length() > maximo)
            throw new ExceptionValidation("El campo '%s' no puede exceder los %d caracteres".formatted(field, maximo));
    }

    public static void ValidateStringField(String nombre, String field, int logitud) {
        validateFieldisEmpty(nombre,field);
        validateNombreLength(nombre, logitud, field);
    }


}
