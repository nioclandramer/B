package com.example.ProyectoParaFrontEnd.Repositorios;

import com.example.ProyectoParaFrontEnd.Entidades.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CarroRepositorio extends JpaRepository<Carro, Long> {
    @Query("SELECT c FROM Carro c WHERE " +
            "(coalesce(:ubicacion, null) IS NULL OR c.ubicacion = :ubicacion) AND " +
            "(coalesce(:fechaInicio, null) IS NULL OR c.fechaInicio >= :fechaInicio) AND " +
            "(coalesce(:fechaFin, null) IS NULL OR c.fechaFin <= :fechaFin)")
    List<Carro> findByFilters(@Param("ubicacion") String ubicacion,
                              @Param("fechaInicio") LocalDate fechaInicio,
                              @Param("fechaFin") LocalDate fechaFin);
}
