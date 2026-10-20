package com.example.backend1.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "asesores_academicos")

public class AsesorAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_asesor;

    //Relacion 1 a 1 con Usuarios
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private  Usuarios usuarios;

    @Column(nullable = false)
    private String nombre_completo;

    private String departamentos;
    private Integer maximo_alumnos;
}
