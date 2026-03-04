package com.rafael.CadastroDJs.services;

import com.rafael.CadastroDJs.DTOs.request.EventoRequestDTO;
import com.rafael.CadastroDJs.DTOs.response.EventoResponseDTO;
import com.rafael.CadastroDJs.exceptions.ResourceNotFoundException;
import com.rafael.CadastroDJs.models.DJModel;
import com.rafael.CadastroDJs.models.EventoModel;
import com.rafael.CadastroDJs.repositories.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        EventoModel evento = buscarOuFalhar(id);
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
        EventoModel eventoExistente = buscarOuFalhar(id);

        eventoExistente.setEvento(request.evento());
        eventoExistente.setLocal(request.local());
        eventoExistente.setDuracao(request.duracao());

        EventoModel eventoAtualizado = eventoRepository.save(eventoExistente);
        return converterParaResponseDTO(eventoAtualizado);
    }

    public void delete(Long id) {
        EventoModel evento = buscarOuFalhar(id);
        eventoRepository.deleteById(id);
    }

    private EventoModel buscarOuFalhar(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado"));
    }

    private EventoResponseDTO converterParaResponseDTO(EventoModel model) {
        List<String> djsConfirmados = Optional.ofNullable(model.getDjs())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(DJModel::getDj)
                .toList();

        return new EventoResponseDTO(
                model.getId(),
                model.getEvento(),
                model.getLocal(),
                model.getDuracao(),
                djsConfirmados
        );
    }
}

