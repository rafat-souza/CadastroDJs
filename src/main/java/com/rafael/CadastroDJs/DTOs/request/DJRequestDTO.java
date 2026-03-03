package com.rafael.CadastroDJs.DTOs.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DJRequestDTO(
        @NotBlank String dj,
        String label,
        int idade,
        @NotBlank String email,
        @NotNull Long eventoId
) { }
