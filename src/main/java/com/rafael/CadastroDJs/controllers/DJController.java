package com.rafael.CadastroDJs.controllers;

import com.rafael.CadastroDJs.DTOs.request.DJRequestDTO;
import com.rafael.CadastroDJs.DTOs.response.DJResponseDTO;
import com.rafael.CadastroDJs.documentation.DJControllerDoc;
import com.rafael.CadastroDJs.models.DJModel;
import com.rafael.CadastroDJs.services.DJService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/djs")
@RequiredArgsConstructor // Substitui construtor (faz a injeção de dependência) para pegar serviço
public class DJController implements DJControllerDoc {

    private final DJService services;

    @Override
    @GetMapping
    public ResponseEntity<List<DJResponseDTO>> getAll() {
        return ResponseEntity.ok(services.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DJResponseDTO> get(@PathVariable Long id) {
        DJResponseDTO dj = services.get(id);
        return ResponseEntity.ok(dj);
    }

    @PostMapping
    public ResponseEntity<DJResponseDTO> create(@RequestBody @Valid DJRequestDTO request) { // @RequestBody chama os atributos da class (colunas da tabela)
        DJResponseDTO savedDj = services.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DJResponseDTO> update(@PathVariable Long id, @RequestBody @Valid DJRequestDTO request) {
        DJResponseDTO updatedDj = services.update(id, request);
        return ResponseEntity.ok(updatedDj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
}
