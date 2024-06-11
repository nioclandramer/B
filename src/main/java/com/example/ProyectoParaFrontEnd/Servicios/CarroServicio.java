package com.example.ProyectoParaFrontEnd.Servicios;

import com.example.ProyectoParaFrontEnd.Dtos.CarroDto.CarroDto;
import com.example.ProyectoParaFrontEnd.Dtos.CarroDto.CarroToSaveDto;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CarroServicio {
    CarroDto guardarCarro(CarroToSaveDto carroToSaveDto);
    CarroDto actualizarCarro(Long id,CarroToSaveDto carroToSaveDto);
    CarroDto findById(long id);
    void deleteById(Long id);
    Optional<List<CarroDto>> getAllCarros();
    List<CarroDto> findByFilters(String ubicacion,LocalDate fechaInicio, LocalDate fechaFin);
}
