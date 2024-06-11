package com.example.ProyectoParaFrontEnd.Dtos.RentaDto;

import com.example.ProyectoParaFrontEnd.Entidades.Renta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RentaMapper {
    RentaMapper INSTANCE= Mappers.getMapper(RentaMapper.class);
    RentaDto RentaToRentaDto(Renta renta);
    Renta RentaDtoToRenta(RentaDto rentaDto);
    Renta RentaToSaveDtoToRenta(RentaToSaveDto rentaToSaveDto);
}
