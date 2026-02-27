package com.rafael.CadastroDJs.controllers;

import com.rafael.CadastroDJs.models.DJModel;
import com.rafael.CadastroDJs.services.DJService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping
    public DJModel create(@RequestBody DJModel dj) {
        return services.create(dj);
    }
}
