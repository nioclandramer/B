package com.example.ProyectoParaFrontEnd.Dtos.CarroDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CarroToSaveDto(String ubicacion,
                             String modelo,
                             LocalDate fechaInicio,
                             LocalDate fechaFin,
                             Float precio,
                             String url) {
}
