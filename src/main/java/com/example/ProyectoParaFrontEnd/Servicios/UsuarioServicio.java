package com.example.ProyectoParaFrontEnd.Servicios;

import com.example.ProyectoParaFrontEnd.Dtos.UsuarioDto.UsuarioDto;
import com.example.ProyectoParaFrontEnd.Dtos.UsuarioDto.UsuarioToSaveDto;
import com.example.ProyectoParaFrontEnd.Excepciones.UsuarioNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UsuarioServicio {
    UsuarioDto guardarUsuario(UsuarioToSaveDto usuarioToSaveDto);
    UsuarioDto actualizarUsuario(Long id,UsuarioToSaveDto usuarioToSaveDto);
    UsuarioDto findById(Long id)throws UsuarioNotFoundException;
    void deleteById(Long id)throws UsuarioNotFoundException;
    Optional<List<UsuarioDto>> getAllUsuarios();
}
