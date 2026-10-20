package com.example.backend1.models;

import com.example.backend1.models.enums.EstadoPostulacion;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table ( name= "Postulaciones")
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPostulacion;


    //establecer la relacion de muchos a 1 a 1 con la tabla de Alumnos

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_control",
            nullable = false)
    private Alumno alumno;

    //establcer la relacion de tablas de muchos a 1 con la tabla de proyecto residencia

    private LocalDate fechaSolicitud = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private EstadoPostulacion estado = EstadoPostulacion.EN_REVISION;

    @Column(columnDefinition = "TEXT")
    private String comentariosEmpresa;


}
