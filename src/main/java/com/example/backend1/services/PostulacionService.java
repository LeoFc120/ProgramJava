package com.example.backend1.services;

import com.example.backend1.models.Postulacion;
import com.example.backend1.repositories.PostulacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostulacionService {

    private final PostulacionRepository postulacionRepository;

    public Postulacion guardar(Postulacion postulacion) {
        return postulacionRepository.save(postulacion);
    }

    public List<Postulacion> obtenerTodos() {
        return postulacionRepository.findAll();
    }

    public Optional<Postulacion> obtenerPorId(Long id) {
        return postulacionRepository.findById(id);
    }

    public Postulacion actualizar(Long id, Postulacion datos) {
        Postulacion existente = postulacionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Postulación no encontrada"));

        // TODO: Cambia estos set por los campos reales de tu modelo Postulacion
        // existente.setEstado(datos.getEstado());
        // existente.setFecha(datos.getFecha());

        return postulacionRepository.save(existente);
    }

    public void eliminar(Long id) {
        postulacionRepository.deleteById(id);
    }
}