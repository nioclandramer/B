package com.example.ProyectoParaFrontEnd.Dtos.CarroDto;

import com.example.ProyectoParaFrontEnd.Dtos.RentaDto.RentaDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public record CarroDto(Long id,
                       String ubicacion,
                       String modelo,
                       LocalDate fechaInicio,
                       LocalDate fechaFin,
                       Float precio,
                       String url) {
}
