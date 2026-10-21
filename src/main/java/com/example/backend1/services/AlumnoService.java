package com.example.backend1.services;

import com.example.backend1.models.Alumno;
import com.example.backend1.repositories.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public Alumno guardar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public List<Alumno> obtenerTodos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> obtenerPorId(String id) {
        return alumnoRepository.findById(id);
    }

    public Alumno actualizar(String id, Alumno datos) {
        Alumno existente = alumnoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrado"));

        // TODO: Cambia estos set por los campos reales que tenga tu modelo Alumno
        // existente.setNombre(datos.getNombre());
        // existente.setApellido(datos.getApellido());

        return alumnoRepository.save(existente);
    }

    public void eliminar(String id) {
        alumnoRepository.deleteById(id);
    }
}