package com.example.ProyectoParaFrontEnd.Dtos.UsuarioDto;

public record UsuarioToSaveDto(String nombre,
                               String apellido,
                               String direccion,
                               String telefono,
                               String cedula) {
}
