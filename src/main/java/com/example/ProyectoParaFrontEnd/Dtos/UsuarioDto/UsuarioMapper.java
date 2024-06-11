package com.example.ProyectoParaFrontEnd.Dtos.UsuarioDto;

import com.example.ProyectoParaFrontEnd.Entidades.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE= Mappers.getMapper(UsuarioMapper.class);
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
    Usuario usuarioToSaveDtoToUsuario(UsuarioToSaveDto usuarioToSaveDto);
}
