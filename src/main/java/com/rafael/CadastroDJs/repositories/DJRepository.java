package com.rafael.CadastroDJs.repositories;

import com.rafael.CadastroDJs.models.DJModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DJRepository extends JpaRepository<DJModel, Long> {
}
