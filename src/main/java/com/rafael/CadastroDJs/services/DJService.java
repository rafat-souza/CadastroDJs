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
        DJModel djModel = buscarDjOuFalhar(id);
        return converterParaResponseDTO(djModel);
    }

    public DJResponseDTO create(DJRequestDTO request) {
        EventoModel evento = buscarEventoOuFalhar(request.eventoId());

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
        DJModel djExistente = buscarDjOuFalhar(id);

        EventoModel evento = buscarEventoOuFalhar(request.eventoId());

        djExistente.setDj(request.dj());
        djExistente.setLabel(request.label());
        djExistente.setIdade(request.idade());
        djExistente.setEmail(request.email());
        djExistente.setEvento(evento);

        DJModel djAtualizado = djRepository.save(djExistente);

        return converterParaResponseDTO(djAtualizado);
    }

    public void delete(Long id) {
        DJModel dj = buscarDjOuFalhar(id);
        djRepository.delete(dj);
    }

    private DJModel buscarDjOuFalhar(Long id) {
        return djRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DJ não encontrado."));
    }

    private EventoModel buscarEventoOuFalhar(Long eventoId) {
        return eventoRepository.findById(eventoId)
                .orElseThrow(() -> new ResourceNotFoundException("Evento de ID " + eventoId + " não encontrado."));
    }

    private DJResponseDTO converterParaResponseDTO(DJModel model) {
        Long idEvento = null;
        String Evento = "Sem evento";

        if (model.getEvento() != null) {
            idEvento = model.getEvento().getId();
            Evento = model.getEvento().getEvento();
        }

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
