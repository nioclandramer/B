package com.example.ProyectoParaFrontEnd.Api;

import com.example.ProyectoParaFrontEnd.Dtos.CarroDto.CarroDto;
import com.example.ProyectoParaFrontEnd.Dtos.CarroDto.CarroToSaveDto;
import com.example.ProyectoParaFrontEnd.Excepciones.CarroNotFoundException;
import com.example.ProyectoParaFrontEnd.Servicios.CarroServicio;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carro")
public class CarroControlador {
    private final CarroServicio carroServicio;

    public CarroControlador(CarroServicio carroServicio) {
        this.carroServicio = carroServicio;
    }
    @PostMapping
    public ResponseEntity<CarroDto> create(@RequestBody CarroToSaveDto carroToSaveDto) {
        CarroDto carroDto=carroServicio.guardarCarro(carroToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroDto);
    }

    @GetMapping
    public ResponseEntity<Optional<List<CarroDto>>>getAll(){
        Optional<List<CarroDto>> carroDtos=carroServicio.getAllCarros();
        return ResponseEntity.ok().body(carroDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarroDto> getById(@PathVariable Long id){
        try {
            CarroDto carroDto= carroServicio.findById(id);
            return ResponseEntity.ok().body(carroDto);
        }catch (CarroNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/filtrar")
    public ResponseEntity<List<CarroDto>>BuscarPorFiltro(@RequestParam(required = false) String ubicacion,
                                                         @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
                                                         @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        List<CarroDto> carroDtos= carroServicio.findByFilters(ubicacion, fechaInicio, fechaFin);
        return ResponseEntity.ok().body(carroDtos);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CarroToSaveDto carroToSaveDto){
        try {
            carroServicio.actualizarCarro(id, carroToSaveDto);
            return ResponseEntity.noContent().build();
        }catch (CarroNotFoundException c){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        try{
            carroServicio.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch (CarroNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}
