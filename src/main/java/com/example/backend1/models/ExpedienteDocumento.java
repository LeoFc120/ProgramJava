package com.example.backend1.models;

import com.example.backend1.models.enums.TipoDocumento;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "expedientes_documentos")
@Data
@NoArgsConstructor
public class ExpedienteDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_documento;

    // Relación Muchos a 1 con Postulacion
    @ManyToOne
    @JoinColumn(name = "id_postulacion", nullable = false)
    private Postulacion postulacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipo_documento;

    @Column(nullable = false)
    private String ruta_archivo_url;

    private LocalDate fecha_subida;

    private Boolean estado_aprobacion;
}
