package com.rafael.CadastroDJs.DTOs.request;

import jakarta.validation.constraints.NotBlank;

public record EventoRequestDTO(
        @NotBlank String evento,
        String local,
        int duracao
) { }
