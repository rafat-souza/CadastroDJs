package com.rafael.CadastroDJs.repositories;

import com.rafael.CadastroDJs.models.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<EventoModel, Long> {
}
