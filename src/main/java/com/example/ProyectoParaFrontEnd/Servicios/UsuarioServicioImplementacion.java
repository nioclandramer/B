package com.example.ProyectoParaFrontEnd.Servicios;

import com.example.ProyectoParaFrontEnd.Dtos.UsuarioDto.UsuarioDto;
import com.example.ProyectoParaFrontEnd.Dtos.UsuarioDto.UsuarioMapper;
import com.example.ProyectoParaFrontEnd.Dtos.UsuarioDto.UsuarioToSaveDto;
import com.example.ProyectoParaFrontEnd.Entidades.Usuario;
import com.example.ProyectoParaFrontEnd.Excepciones.UsuarioNotFoundException;
import com.example.ProyectoParaFrontEnd.Repositorios.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImplementacion implements UsuarioServicio {
    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImplementacion(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioToSaveDto usuarioToSaveDto) {
        Usuario usuario= UsuarioMapper.INSTANCE.usuarioToSaveDtoToUsuario(usuarioToSaveDto);
        Usuario usuarioGuardado=usuarioRepositorio.save(usuario);
        return UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuarioGuardado);
    }

    @Override
    public UsuarioDto actualizarUsuario(Long id, UsuarioToSaveDto usuarioToSaveDto) {
        Usuario usuario= UsuarioMapper.INSTANCE.usuarioToSaveDtoToUsuario(usuarioToSaveDto);
        Usuario usuarioExiste=usuarioRepositorio.findById(id).orElseThrow(()->new UsuarioNotFoundException("No se encontró el usuario"));
        usuarioExiste.setNombre(usuario.getNombre());
        usuarioExiste.setApellido(usuario.getApellido());
        usuarioExiste.setCedula(usuario.getCedula());
        usuarioExiste.setDireccion(usuario.getDireccion());
        usuarioExiste.setTelefono(usuario.getTelefono());

        usuarioRepositorio.save(usuarioExiste);

        return UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuarioExiste);
    }

    @Override
    public UsuarioDto findById(Long id) throws UsuarioNotFoundException {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(()->new UsuarioNotFoundException("No se encontró el usuario"));
        return UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuario);
    }

    @Override
    public void deleteById(Long id) throws UsuarioNotFoundException {
        Usuario  usuario= usuarioRepositorio.findById(id).orElseThrow(()->new UsuarioNotFoundException("No se encontro el usuario"));
        usuarioRepositorio.deleteById(usuario.getId());
    }

    @Override
    public Optional<List<UsuarioDto>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        List<UsuarioDto> usuarioDtos= usuarios.stream().map(UsuarioMapper.INSTANCE::usuarioToUsuarioDto).collect(Collectors.toList());
        return Optional.of(usuarioDtos);
    }
}
