package com.rafael.CadastroDJs.DTOs.response;

public record DJResponseDTO(
        Long id,
        String dj,
        String label,
        int idade,
        String email,
        String nomeEvento
) { }
