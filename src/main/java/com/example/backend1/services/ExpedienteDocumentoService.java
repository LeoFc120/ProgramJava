package com.example.backend1.services;

import com.example.backend1.models.ExpedienteDocumento;
import com.example.backend1.repositories.ExpedienteDocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpedienteDocumentoService {

    private final ExpedienteDocumentoRepository expedienteDocumentoRepository;

    public ExpedienteDocumento guardar(ExpedienteDocumento documento) {
        return expedienteDocumentoRepository.save(documento);
    }

    public List<ExpedienteDocumento> obtenerTodos() {
        return expedienteDocumentoRepository.findAll();
    }

    public Optional<ExpedienteDocumento> obtenerPorId(Integer id) {
        return expedienteDocumentoRepository.findById(id);
    }

    public ExpedienteDocumento actualizar(Integer id, ExpedienteDocumento datos) {
        ExpedienteDocumento existente = expedienteDocumentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Documento no encontrado"));

        // TODO: Actualiza los campos específicos de ExpedienteDocumento
        // existente.setRutaArchivo(datos.getRutaArchivo());

        return expedienteDocumentoRepository.save(existente);
    }

    public void eliminar(Integer id) {
        expedienteDocumentoRepository.deleteById(id);
    }
}
