package com.example.ProyectoParaFrontEnd.Dtos.RentaDto;

import com.example.ProyectoParaFrontEnd.Dtos.CarroDto.CarroDto;
import com.example.ProyectoParaFrontEnd.Dtos.UsuarioDto.UsuarioDto;

public record RentaToSaveDto(UsuarioDto usuario,
                             CarroDto carro) {
}
