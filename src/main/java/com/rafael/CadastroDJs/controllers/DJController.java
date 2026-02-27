package com.rafael.CadastroDJs.controllers;

import com.rafael.CadastroDJs.models.DJModel;
import com.rafael.CadastroDJs.services.DJService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/djs")
@RequiredArgsConstructor // Substitui construtor (faz a injeção de dependência) para pegar serviço
public class DJController {

    private final DJService services;

    // Puxando serviço do arquivo DJService
    @GetMapping
    public List<DJModel> getAll() {
        return services.getAll();
    }
}
