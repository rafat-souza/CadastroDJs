package com.rafael.CadastroDJs.services;

import com.rafael.CadastroDJs.exceptions.ResourceNotFoundException;
import com.rafael.CadastroDJs.models.DJModel;
import com.rafael.CadastroDJs.repositories.DJRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DJService {

    private final DJRepository djRepository; // O arquivo de repositório importa o JpaRepository, que contém os métodos para os serviços.

    // Resgatar todos os DJs.
    public List<DJModel> getAll() {
        return djRepository.findAll();
    }

    // Resgatar um único DJ.
    public DJModel get(Long id) { return djRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("DJ não encontrado")); }

    // Postar ou atualizar DJ.
    public DJModel create(DJModel dj) {
        return djRepository.save(dj);
    }

    // Deletar DJ. Void porque não precisa retornar nada
    public void delete(Long id) {
        if (!djRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não foi possível deletar: DJ não encontrado");
        }
        djRepository.deleteById(id);
    }
}
