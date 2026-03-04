package com.rafael.CadastroDJs.DTOs.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EventoRequestDTO(
        @NotBlank String evento,
        String local,
        @NotNull int duracao
) { }
