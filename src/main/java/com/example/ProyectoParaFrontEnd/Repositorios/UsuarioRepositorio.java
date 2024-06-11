package com.example.ProyectoParaFrontEnd.Repositorios;

import com.example.ProyectoParaFrontEnd.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
}
