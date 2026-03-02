package com.rafael.CadastroDJs.services;

import com.rafael.CadastroDJs.exceptions.ResourceNotFoundException;
import com.rafael.CadastroDJs.models.EventoModel;
import com.rafael.CadastroDJs.repositories.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoService {
    private final EventoRepository eventoRepository;

    public List<EventoModel> getAll() {
        return eventoRepository.findAll();
    }

    public EventoModel get(Long id) {
        return eventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado"));
    }

    public EventoModel create(EventoModel evento) {
        return eventoRepository.save(evento);
    }

    public void delete(Long id) {
        if (!eventoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não foi possível deletar: Evento não encontrado");
        }
        eventoRepository.deleteById(id);
    }
}

