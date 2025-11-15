package com.esp.usuario.utils;

public class SqlBuilderUsuario {


    private static final String CONSULTA_TXT = """
            SELECT
                u.id_usuario,
                ub.nombre_ubicacion as ubicacion,
                u.nombres_usuario as nombres,
                u.apellidos_usuario as apellidos,
                u.documento_usuario as identificacion
            FROM usuarios u
            JOIN ubicaciones ub ON u.id_ubicacion = ub.id_ubicacion
             order by %s %s
            """;

    public static String consulta(String campoOrden, String tipoOrden) {
        return String.format(CONSULTA_TXT, campoOrden, tipoOrden);
    }
}
