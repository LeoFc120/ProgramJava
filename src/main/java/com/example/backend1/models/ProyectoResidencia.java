package com.example.backend1.models;

import com.example.backend1.models.enums.EstadoProyecto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "proyectos_residencia")

public class ProyectoResidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id_proyecto;

    //Relacion muchos a 1 con Empresa
    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descipcion;

    @Column(columnDefinition = "TEXT")
    private String objetivo;

    @Column(columnDefinition = "TEXT")
    private String tecnologias_requeridos;

    @Column(nullable = false)
    private Integer cupo_alumnos;

    @Enumerated(EnumType.STRING)
    private EstadoProyecto estado;

    private LocalDate fecha_publicacion;


}
