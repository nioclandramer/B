package com.example.ProyectoParaFrontEnd.Servicios;

import com.example.ProyectoParaFrontEnd.Dtos.RentaDto.RentaDto;
import com.example.ProyectoParaFrontEnd.Dtos.RentaDto.RentaToSaveDto;
import com.example.ProyectoParaFrontEnd.Excepciones.RentaNotFoundException;

import java.util.List;
import java.util.Optional;

public interface RentaServicio {
    RentaDto guardarRenta(RentaToSaveDto rentaToSaveDto);
    RentaDto actualizarRenta(Long id,RentaToSaveDto rentaToSaveDto);
    void deleteById(Long id) throws RentaNotFoundException;
    RentaDto buscarRentaPorId(Long id) throws RentaNotFoundException;
    Optional<List<RentaDto>> getAll();

}
