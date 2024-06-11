package com.example.ProyectoParaFrontEnd.Api;

import com.example.ProyectoParaFrontEnd.Dtos.UsuarioDto.UsuarioDto;
import com.example.ProyectoParaFrontEnd.Dtos.UsuarioDto.UsuarioToSaveDto;
import com.example.ProyectoParaFrontEnd.Excepciones.UsuarioNotFoundException;
import com.example.ProyectoParaFrontEnd.Servicios.UsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioControlador {
    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
    @PostMapping
    public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioToSaveDto usuarioToSaveDto) {
        UsuarioDto usuarioDto= usuarioServicio.guardarUsuario(usuarioToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
    }
    @GetMapping
    public ResponseEntity<Optional<List<UsuarioDto>>> getAll() {
        Optional<List<UsuarioDto>> usuarioDtos= usuarioServicio.getAllUsuarios();
        return ResponseEntity.ok().body(usuarioDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable Long id) {
        try{
            UsuarioDto usuarioDto= usuarioServicio.findById(id);
            return ResponseEntity.ok().body(usuarioDto);
        }catch (UsuarioNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody UsuarioToSaveDto usuarioToSaveDto) {
        try{
            usuarioServicio.actualizarUsuario(id, usuarioToSaveDto);
            return  ResponseEntity.noContent().build();
        }catch (UsuarioNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try{
            usuarioServicio.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch (UsuarioNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
