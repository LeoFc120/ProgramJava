package com.example.backend1.repositories;

import com.example.backend1.models.ExpedienteDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpedienteDocumentoRepository extends JpaRepository<ExpedienteDocumento, Integer> {
}