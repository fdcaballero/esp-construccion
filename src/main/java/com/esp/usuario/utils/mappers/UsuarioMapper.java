package com.esp.usuario.utils.mappers;

import com.esp.infraestructura.utils.mappers.MapperEntitytoDto;

import com.esp.usuario.dto.UsuarioDtoCrear;
import com.esp.usuario.dto.UsuarioDtoRespuesta;
import com.esp.usuario.entity.Ubicacion;
import com.esp.usuario.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper implements MapperEntitytoDto<Usuario, UsuarioDtoRespuesta> {

    @Override
    public Usuario toEntity(UsuarioDtoRespuesta dto) {
        if (dto == null) return null;
        Usuario usuario = new Usuario();
        usuario.setNombresUsuario(dto.nombresUsuario());
        usuario.setApellidosUsuario(dto.apellidosUsuario());
        usuario.setDocumentoUsuario(dto.documentoUsuario());
        usuario.setTipoDocumentoUsuario(dto.tipoDocumentoUsuario());
        usuario.setEstadoUsuario(dto.estadoUsuario());
        return usuario;
    }

    @Override
    public UsuarioDtoRespuesta toDto(Usuario entity) {
        if (entity == null) return null;
        return new UsuarioDtoRespuesta(
                entity.getNombresUsuario(),
                entity.getApellidosUsuario(),
                entity.getDocumentoUsuario(),
                entity.getTipoDocumentoUsuario(),
                entity.getEstadoUsuario());
    }


    public Usuario fromDto(UsuarioDtoCrear dto, Object... objects) {
        if (dto == null) return null;
        Usuario usuario = new Usuario();
        usuario.setNombresUsuario(dto.getNombresUsuario());
        usuario.setApellidosUsuario(dto.getApellidosUsuario());
        usuario.setDocumentoUsuario(dto.getDocumentoUsuario());
        usuario.setTipoDocumentoUsuario(dto.getTipoDocumento());
        usuario.setEstadoUsuario(dto.getEstadoUsuario());
        if (dto.getIdUbicacion() != null)
            usuario.setUbicacion(new Ubicacion(dto.getIdUbicacion()));

        return usuario;
    }
}
