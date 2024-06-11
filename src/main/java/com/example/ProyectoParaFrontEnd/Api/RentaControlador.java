package com.example.ProyectoParaFrontEnd.Api;

import com.example.ProyectoParaFrontEnd.Dtos.RentaDto.RentaDto;
import com.example.ProyectoParaFrontEnd.Dtos.RentaDto.RentaToSaveDto;
import com.example.ProyectoParaFrontEnd.Entidades.Renta;
import com.example.ProyectoParaFrontEnd.Excepciones.RentaNotFoundException;
import com.example.ProyectoParaFrontEnd.Servicios.RentaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/renta")
public class RentaControlador {
    private final RentaServicio rentaServicio;

    public RentaControlador(RentaServicio rentaServicio) {
        this.rentaServicio = rentaServicio;
    }
    @PostMapping
    public ResponseEntity<RentaDto> create(@RequestBody RentaToSaveDto rentaToSaveDto) {
        RentaDto  rentaDto= rentaServicio.guardarRenta(rentaToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(rentaDto);
    }
    @GetMapping
    public ResponseEntity<Optional<List<RentaDto>>> getAll() {
        Optional<List<RentaDto>> rentaDtos= rentaServicio.getAll();
        return ResponseEntity.ok().body(rentaDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RentaDto> getById(@PathVariable Long id) {
        try {
            RentaDto rentaDto= rentaServicio.buscarRentaPorId(id);
            return ResponseEntity.ok().body(rentaDto);
        }catch (RentaNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody RentaToSaveDto rentaToSaveDto) {
        try{
            rentaServicio.actualizarRenta(id, rentaToSaveDto);
            return ResponseEntity.noContent().build();
        }catch (RentaNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try{
            rentaServicio.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch (RentaNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
