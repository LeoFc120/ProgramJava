package com.example.backend1.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "empresas")

public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_empresas;

    //relacion 1 a 1 con usuarios
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuarios;

    @Column(nullable = false)
    private String razon_social;

    private String sector;
    private  String nombre_contacto;
    private String telefono;

    @Column(columnDefinition = "TEXT")
    private  String direccion;

    private Boolean estado_verificaion;

}
