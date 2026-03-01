package com.rafael.CadastroDJs.services;

import com.rafael.CadastroDJs.models.DJModel;
import com.rafael.CadastroDJs.repositories.DJRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DJService {

    private final DJRepository djRepository; // O arquivo de repositório importa o JpaRepository, que contém os métodos para os serviços.

    // Resgatar todos os DJs.
    public List<DJModel> getAll() {
        return djRepository.findAll();
    }

    // Resgatar um único DJ.
    public DJModel get(Long id) { return djRepository.findById(id).orElseThrow(() -> new RuntimeException("DJ não encontrado")); }

    // Postar ou atualizar DJ.
    public DJModel create(DJModel dj) {
        return djRepository.save(dj);
    }

    // Deletar DJ. Void porque não precisa retornar nada
    public void delete(Long id) {
        djRepository.deleteById(id);
    }
}
