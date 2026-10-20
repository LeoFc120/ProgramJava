package com.example.backend1.models;


import com.example.backend1.models.enums.EstadoResidencia;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity

@Table(name= "Alumnos")

public class Alumno {

    @Id
    private String numeroControl;

    //establkecer la relacion de 1 a 1 con la tabla usuarios

    @OneToOne
    @JoinColumn(name = "id_usuario",
            referencedColumnName = "idUsuario",
            nullable = false,
            unique = true
    )
    private Usuarios usuarios;

    @Column(nullable = false)
    private String nombreCompleto;

    @Column(nullable = false)
    private String Carrera;

    @Column(nullable = false)
    private Integer semestre;

    @Column(columnDefinition = "Text")
    private String habilidadesTecnicas;

    @Enumerated(EnumType.STRING)
    private EstadoResidencia estadoResidencia;





}


