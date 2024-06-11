package com.example.ProyectoParaFrontEnd.Dtos.UsuarioDto;

import com.example.ProyectoParaFrontEnd.Dtos.RentaDto.RentaDto;

import java.util.List;

public record UsuarioDto(Long id,
                         String nombre,
                         String apellido,
                         String direccion,
                         String telefono,
                         String cedula) {
}
