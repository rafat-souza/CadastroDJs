package com.rafael.CadastroDJs.controllers;

import com.rafael.CadastroDJs.DTOs.request.EventoRequestDTO;
import com.rafael.CadastroDJs.DTOs.response.EventoResponseDTO;
import com.rafael.CadastroDJs.services.EventoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoService services;

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> getAll() {
        return ResponseEntity.ok(services.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> get(@PathVariable Long id) {
        EventoResponseDTO evento = services.get(id);
        return ResponseEntity.ok(evento);
    }

    @PostMapping
    public ResponseEntity<EventoResponseDTO> create(@RequestBody @Valid EventoRequestDTO request) {
        EventoResponseDTO savedEvento = services.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> update(@PathVariable Long id, @RequestBody @Valid EventoRequestDTO request) {
        EventoResponseDTO updatedEvento = services.update(id, request);
        return ResponseEntity.ok(updatedEvento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
}
