package com.rafael.CadastroDJs.services;

import com.rafael.CadastroDJs.models.DJModel;
import com.rafael.CadastroDJs.repositories.DJRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DJService {

    private final DJRepository djRepository; // O arquivo de repositório importa o JpaRepository, que contém os métodos para os serviços.

    // Resgatar todos os DJs. O nome do serviço é getAll.
    public List<DJModel> getAll() {return djRepository.findAll();}
}
