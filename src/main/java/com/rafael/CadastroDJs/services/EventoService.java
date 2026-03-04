package com.rafael.CadastroDJs.services;

import com.rafael.CadastroDJs.DTOs.request.EventoRequestDTO;
import com.rafael.CadastroDJs.DTOs.response.EventoResponseDTO;
import com.rafael.CadastroDJs.exceptions.ResourceNotFoundException;
import com.rafael.CadastroDJs.models.DJModel;
import com.rafael.CadastroDJs.models.EventoModel;
import com.rafael.CadastroDJs.repositories.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoService {
    private final EventoRepository eventoRepository;

    public List<EventoResponseDTO> getAll() {
        return eventoRepository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    public EventoResponseDTO get(Long id) {
        EventoModel evento = eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado"));
        return converterParaResponseDTO(evento);
    }

    public EventoResponseDTO create(EventoRequestDTO request) {
        EventoModel novoEvento = new EventoModel();
        novoEvento.setEvento(request.evento());
        novoEvento.setLocal(request.local());
        novoEvento.setDuracao(request.duracao());

        EventoModel eventoSalvo = eventoRepository.save(novoEvento);
        return converterParaResponseDTO(eventoSalvo);
    }

    public EventoResponseDTO update(Long id, EventoRequestDTO request) {
        EventoModel eventoExistente = eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado"));

        eventoExistente.setEvento(request.evento());
        eventoExistente.setLocal(request.local());
        eventoExistente.setDuracao(request.duracao());

        EventoModel eventoAtualizado = eventoRepository.save(eventoExistente);
        return converterParaResponseDTO(eventoAtualizado);
    }

    public void delete(Long id) {
        if (!eventoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não foi possível deletar: Evento não encontrado");
        }
        eventoRepository.deleteById(id);
    }

    private EventoResponseDTO converterParaResponseDTO(EventoModel model) {
        List<String> djsConfirmados = new ArrayList<>();

        if (model.getDjs() != null && !model.getDjs().isEmpty()) {
            djsConfirmados = model.getDjs().stream()
                    .map(DJModel::getDj)
                    .toList();
        }

        return new EventoResponseDTO(
                model.getId(),
                model.getEvento(),
                model.getLocal(),
                model.getDuracao(),
                djsConfirmados
        );
    }
}

