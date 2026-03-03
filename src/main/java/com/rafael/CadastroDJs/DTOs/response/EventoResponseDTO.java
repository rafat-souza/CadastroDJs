package com.rafael.CadastroDJs.DTOs.response;

import java.util.List;

public record EventoResponseDTO(
        Long id,
        String evento,
        String local,
        int duracao,
        List<String> djs
) { }
