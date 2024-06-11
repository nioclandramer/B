package com.example.ProyectoParaFrontEnd.Servicios;

import com.example.ProyectoParaFrontEnd.Dtos.CarroDto.CarroDto;
import com.example.ProyectoParaFrontEnd.Dtos.CarroDto.CarroMapper;
import com.example.ProyectoParaFrontEnd.Dtos.CarroDto.CarroToSaveDto;
import com.example.ProyectoParaFrontEnd.Entidades.Carro;
import com.example.ProyectoParaFrontEnd.Excepciones.CarroNotFoundException;
import com.example.ProyectoParaFrontEnd.Repositorios.CarroRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroServicioImplementacion implements CarroServicio {
    private final CarroRepositorio carroRepositorio;

    public CarroServicioImplementacion(CarroRepositorio carroRepositorio) {
        this.carroRepositorio = carroRepositorio;
    }

    @Override
    public CarroDto guardarCarro(CarroToSaveDto carroToSaveDto) {
        Carro carro = CarroMapper.INSTANCE.CarroToSaveDtoToCarro(carroToSaveDto);
        Carro carroSaved = carroRepositorio.save(carro);
        return CarroMapper.INSTANCE.CarroToCarroDto(carroSaved);
    }

    @Override
    public CarroDto actualizarCarro(Long id, CarroToSaveDto carroToSaveDto) {
        Carro carro= CarroMapper.INSTANCE.CarroToSaveDtoToCarro(carroToSaveDto);
        Carro carroExistente = carroRepositorio.findById(id).orElseThrow(()-> new CarroNotFoundException("Carro no encontrado"));
        carroExistente.setFechaFin(carro.getFechaFin());
        carroExistente.setFechaInicio(carro.getFechaInicio());
        carroExistente.setUbicacion(carro.getUbicacion());
        carroExistente.setModelo(carro.getModelo());
        carroExistente.setPrecio(carro.getPrecio());
        carroExistente.setUrl(carro.getUrl());
        carroExistente=carroRepositorio.save(carroExistente);

        return CarroMapper.INSTANCE.CarroToCarroDto(carroExistente);
    }

    @Override
    public CarroDto findById(long id) {
        Carro carro= carroRepositorio.findById(id).orElseThrow(()-> new CarroNotFoundException("Carro no encontrado"));
        return CarroMapper.INSTANCE.CarroToCarroDto(carro);
    }

    @Override
    public void deleteById(Long id) {
        Carro carro= carroRepositorio.findById(id).orElseThrow(()-> new CarroNotFoundException("Carro no encontrado"));
        carroRepositorio.delete(carro);
    }

    @Override
    public Optional<List<CarroDto>> getAllCarros() {
        List<Carro> carros = carroRepositorio.findAll();
        List<CarroDto> carroDtos= carros.stream().map(CarroMapper.INSTANCE::CarroToCarroDto).collect(Collectors.toList());
        return Optional.of(carroDtos);
    }

    @Override
    public List<CarroDto> findByFilters(String ubicacion, LocalDate fechaInicio, LocalDate fechaFin) {
        List<Carro> carros=carroRepositorio.findByFilters(ubicacion, fechaInicio, fechaFin);
        List<CarroDto> carroDtos= carros.stream().map(CarroMapper.INSTANCE::CarroToCarroDto).collect(Collectors.toList());
        return carroDtos;
    }


}
