package com.esp.area.utils.validators;

import com.esp.infraestructura.exception.ExceptionValidation;

public class AreaValidator {
    private static final int LONGITUD = 150;


    private static void validarNombreVacio(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ExceptionValidation("Nombre de área es requerido");
        }
    }

    public static void validarLogintud(String nombre, int maximo) {
        if (nombre != null && nombre.trim().length() > maximo) {
            throw new ExceptionValidation("Longitud del nombre superada");
        }
    }

    public static void validarNombre(String nombre) {
        validarNombreVacio(nombre);
        validarLogintud(nombre, LONGITUD);
    }
}
