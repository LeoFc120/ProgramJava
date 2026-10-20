package com.example.backend1.repositories;

import com.example.backend1.models.ProyectoResidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoResidenciaRepository extends JpaRepository<ProyectoResidencia, Integer> {
}