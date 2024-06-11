package com.example.ProyectoParaFrontEnd.Servicios;

import com.example.ProyectoParaFrontEnd.Dtos.RentaDto.RentaDto;
import com.example.ProyectoParaFrontEnd.Dtos.RentaDto.RentaMapper;
import com.example.ProyectoParaFrontEnd.Dtos.RentaDto.RentaToSaveDto;
import com.example.ProyectoParaFrontEnd.Entidades.Renta;
import com.example.ProyectoParaFrontEnd.Excepciones.RentaNotFoundException;
import com.example.ProyectoParaFrontEnd.Repositorios.RentaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class RentaServicioImplementacion implements RentaServicio{
    private final RentaRepositorio rentaRepositorio;

    public RentaServicioImplementacion(RentaRepositorio rentaRepositorio) {
        this.rentaRepositorio = rentaRepositorio;
    }

    @Override
    public RentaDto guardarRenta(RentaToSaveDto rentaToSaveDto) {
        Renta renta = RentaMapper.INSTANCE.RentaToSaveDtoToRenta(rentaToSaveDto);
        Renta rentaSaved = rentaRepositorio.save(renta);

        return RentaMapper.INSTANCE.RentaToRentaDto(rentaSaved);
    }

    @Override
    public RentaDto actualizarRenta(Long id, RentaToSaveDto rentaToSaveDto) {
        Renta renta= RentaMapper.INSTANCE.RentaToSaveDtoToRenta(rentaToSaveDto);
        Renta rentaExiste= rentaRepositorio.findById(id).orElseThrow(()-> new RentaNotFoundException("Renta no encontrada"));
        rentaExiste.setCarro(renta.getCarro());
        rentaExiste.setUsuario(renta.getUsuario());
        rentaRepositorio.save(rentaExiste);
        return RentaMapper.INSTANCE.RentaToRentaDto(rentaExiste);
    }

    @Override
    public void deleteById(Long id) throws RentaNotFoundException {
        Renta renta= rentaRepositorio.findById(id).orElseThrow(()-> new RentaNotFoundException("Renta no encontrada"));
        rentaRepositorio.deleteById(id);
    }

    @Override
    public RentaDto buscarRentaPorId(Long id) throws RentaNotFoundException {
        Renta renta= rentaRepositorio.findById(id).orElseThrow(()-> new RentaNotFoundException("Renta no encontrada"));
        return RentaMapper.INSTANCE.RentaToRentaDto(renta);
    }

    @Override
    public Optional<List<RentaDto>> getAll() {
            List<Renta> rentaList= rentaRepositorio.findAll();
            List<RentaDto> rentaDtos= rentaList.stream().map(RentaMapper.INSTANCE::RentaToRentaDto).collect(Collectors.toList());
        return Optional.of(rentaDtos);
    }
}
