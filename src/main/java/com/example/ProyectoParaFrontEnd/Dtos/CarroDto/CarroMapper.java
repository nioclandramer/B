package com.example.ProyectoParaFrontEnd.Dtos.CarroDto;

import com.example.ProyectoParaFrontEnd.Entidades.Carro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CarroMapper {
    CarroMapper INSTANCE= Mappers.getMapper(CarroMapper.class);
    Carro CarroDtoToCarro(CarroDto carroDto);
    CarroDto CarroToCarroDto(Carro carro);
    Carro CarroToSaveDtoToCarro(CarroToSaveDto carroToSaveDto);
}
