package com.rafael.CadastroDJs.controllers;

import com.rafael.CadastroDJs.models.DJModel;
import com.rafael.CadastroDJs.models.EventoModel;
import com.rafael.CadastroDJs.services.EventoService;
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
    public List<EventoModel> getAll() {
        return services.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoModel> get(@PathVariable Long id) {
        EventoModel evento = services.get(id);
        return ResponseEntity.ok(evento);
    }

    @PostMapping
    public ResponseEntity<EventoModel> create(@RequestBody EventoModel evento) {
        EventoModel savedEvento = services.create(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoModel> update(@PathVariable Long id, @RequestBody EventoModel evento) {
        evento.setId(id);
        EventoModel updatedEvento = services.create(evento);
        return ResponseEntity.ok(updatedEvento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
}
