package com.esp.vacante.utils;

public class SqlBuilderVacante {

    private static final String CONSULTA_TXT = """
            select v.id_vacante,
                   v.titulo_vacante,
                   v.detalle_vacante,
                   v.fecha_inicio_vacante,
                   v.fecha_fin_vacante,
                   v.min_salario_vacante,
                   v.max_salario_vacante,
                   e.nombre_empresa,
                   u.nombre_ubicacion,
                   a.nombre_privado_anuncio as anuncio,
                   j.nombre_jornada,
                   m.nombre_modalidad,
                   tc.nombre_tipo_contrato,
                   ev.nombre_estado_vacante,
                   coalesce(string_agg(pc.texto_palabra_clave, ','), '') as palabras_clave
            from vacantes v
                     inner join ubicaciones u on v.id_ubicacion = u.id_ubicacion
                     Inner join empresas e on v.id_empresa = e.id_empresa
                     Inner join jornadas j on v.id_jornada = j.id_jornada
                     inner join modalidades m on v.id_modalidad = m.id_modalidad
                     inner join tipos_contratos tc on v.id_tipo_contrato = tc.id_tipo_contrato
                     inner join estados_vacantes ev on ev.id_estado_vacante = v.estado_vacante
                     left join rel_vacante_palabraclave rvp on v.id_vacante = rvp.id_vacante
                     inner join palabras_claves pc on rvp.id_palabra_clave = pc.id_palabra_clave
                     left JOIN anuncios a on v.id_vacante = a.id_vacante
            group by v.id_vacante, v.detalle_vacante, v.fecha_inicio_vacante, v.fecha_fin_vacante, v.min_salario_vacante,
                     v.max_salario_vacante, e.nombre_empresa, a.nombre_privado_anuncio, j.nombre_jornada, m.nombre_modalidad,
                     ev.nombre_estado_vacante,
                     tc.nombre_tipo_contrato,u.nombre_ubicacion
            order by %s %s
            """;

    public static String consulta(String campoOrden, String tipoOrden) {
        return String.format(CONSULTA_TXT, campoOrden, tipoOrden);
    }

    ;
}
