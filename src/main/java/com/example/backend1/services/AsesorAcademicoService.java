package com.example.backend1.services;

import com.example.backend1.models.AsesorAcademico;
import com.example.backend1.repositories.AsesorAcademicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AsesorAcademicoService {

    private final AsesorAcademicoRepository asesorAcademicoRepository;

    public AsesorAcademico guardar(AsesorAcademico asesor) {
        return asesorAcademicoRepository.save(asesor);
    }

    public List<AsesorAcademico> obtenerTodos() {
        return asesorAcademicoRepository.findAll();
    }

    public Optional<AsesorAcademico> obtenerPorId(Integer id) {
        return asesorAcademicoRepository.findById(id);
    }

    public AsesorAcademico actualizar(Integer id, AsesorAcademico datos) {
        AsesorAcademico existente = asesorAcademicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asesor Académico no encontrado"));

        // TODO: Actualiza los campos específicos de AsesorAcademico
        // existente.setNombreCompleto(datos.getNombreCompleto());

        return asesorAcademicoRepository.save(existente);
    }

    public void eliminar(Integer id) {
        asesorAcademicoRepository.deleteById(id);
    }
}