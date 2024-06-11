package com.example.ProyectoParaFrontEnd.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ubicacion;
    private String modelo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Float precio;
    private String url;
    @OneToMany(mappedBy = "carro")
    private List<Renta> rentas;
}
