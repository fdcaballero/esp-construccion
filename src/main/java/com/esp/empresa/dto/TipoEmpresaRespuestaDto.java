package com.esp.empresa.dto;

public record TipoEmpresaRespuestaDto
        (
                Integer idTipoEmpresa,
                String nombreTipoEmpresa,
                Short estadoTipoEmpresa
        ) {
}
