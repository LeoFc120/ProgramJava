package com.example.backend1.services;

import com.example.backend1.models.ProyectoResidencia;
import com.example.backend1.repositories.ProyectoResidenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProyectoResidenciaService {

    private final ProyectoResidenciaRepository proyectoResidenciaRepository;

    public ProyectoResidencia guardar(ProyectoResidencia proyecto) {
        return proyectoResidenciaRepository.save(proyecto);
    }

    public List<ProyectoResidencia> obtenerTodos() {
        return proyectoResidenciaRepository.findAll();
    }

    public Optional<ProyectoResidencia> obtenerPorId(Integer id) {
        return proyectoResidenciaRepository.findById(id);
    }

    public ProyectoResidencia actualizar(Integer id, ProyectoResidencia datos) {
        ProyectoResidencia existente = proyectoResidenciaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyecto no encontrado"));

        // TODO: Actualiza los campos específicos de ProyectoResidencia
        // existente.setTitulo(datos.getTitulo());

        return proyectoResidenciaRepository.save(existente);
    }

    public void eliminar(Integer id) {
        proyectoResidenciaRepository.deleteById(id);
    }
}