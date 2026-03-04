package com.rafael.CadastroDJs.services;

import com.rafael.CadastroDJs.DTOs.request.DJRequestDTO;
import com.rafael.CadastroDJs.DTOs.response.DJResponseDTO;
import com.rafael.CadastroDJs.exceptions.ResourceNotFoundException;
import com.rafael.CadastroDJs.models.DJModel;
import com.rafael.CadastroDJs.models.EventoModel;
import com.rafael.CadastroDJs.repositories.DJRepository;
import com.rafael.CadastroDJs.repositories.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DJService {

    private final DJRepository djRepository; // O arquivo de repositório importa o JpaRepository, que contém os métodos para os serviços.

    private final EventoRepository eventoRepository;

    public List<DJResponseDTO> getAll() {
        return djRepository.findAll().stream().map(this::converterParaResponseDTO).toList();
    }

    public DJResponseDTO get(Long id) {
        DJModel djModel = djRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("DJ não encontrado."));
        return converterParaResponseDTO(djModel);
    }

    public DJResponseDTO create(DJRequestDTO request) {
        EventoModel evento = eventoRepository.findById(request.eventoId())
                .orElseThrow(() -> new ResourceNotFoundException("Evento de ID " + request.eventoId() + " não encontrado."));
        DJModel novoDj = new DJModel();
        novoDj.setDj(request.dj());
        novoDj.setLabel(request.label());
        novoDj.setIdade(request.idade());
        novoDj.setEmail(request.email());
        novoDj.setEvento(evento);

        DJModel djSalvo = djRepository.save(novoDj);

        return converterParaResponseDTO(djSalvo);
    }

    public DJResponseDTO update(Long id, DJRequestDTO request) {
        DJModel djExistente = djRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DJ não encontrado"));

        EventoModel evento = eventoRepository.findById(request.eventoId())
                .orElseThrow(() -> new ResourceNotFoundException("Evento de ID " + request.eventoId() + " não encontrado."));

        djExistente.setDj(request.dj());
        djExistente.setLabel(request.label());
        djExistente.setIdade(request.idade());
        djExistente.setEmail(request.email());
        djExistente.setEvento(evento);

        DJModel djAtualizado = djRepository.save(djExistente);

        return converterParaResponseDTO(djAtualizado);
    }

    public void delete(Long id) {
        if (!djRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não foi possível deletar: DJ não encontrado");
        }
        djRepository.deleteById(id);
    }

    private DJResponseDTO converterParaResponseDTO(DJModel model) {
        Long idEvento = (model.getEvento() != null) ? model.getEvento().getId() : null;
        String Evento = (model.getEvento() != null) ? model.getEvento().getEvento() : "Sem evento";

        return new DJResponseDTO(
                model.getId(),
                model.getDj(),
                model.getLabel(),
                model.getIdade(),
                model.getEmail(),
                idEvento,
                Evento
        );
    }
}
