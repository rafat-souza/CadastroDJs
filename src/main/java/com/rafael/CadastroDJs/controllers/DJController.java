package com.rafael.CadastroDJs.controllers;

import com.rafael.CadastroDJs.models.DJModel;
import com.rafael.CadastroDJs.services.DJService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/djs")
@RequiredArgsConstructor // Substitui construtor (faz a injeção de dependência) para pegar serviço
public class DJController {

    private final DJService services;

    // Puxando serviços do arquivo DJService
    @GetMapping
    public List<DJModel> getAll() {
        return services.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DJModel> get(@PathVariable Long id) {
        DJModel dj = services.get(id);
        return ResponseEntity.ok(dj);
    }

    @PostMapping
    public ResponseEntity<DJModel> create(@RequestBody DJModel dj) { // @RequestBody chama os atributos da class (colunas da tabela)
        DJModel savedDj = services.create(dj);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DJModel> update(@PathVariable Long id, @RequestBody DJModel dj) {
        dj.setId(id);
        DJModel updatedDj = services.create(dj);
        return ResponseEntity.ok(updatedDj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
}
