package com.rafael.CadastroDJs.DTOs.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Objeto de resposta contendo os dados de um Evento e a lista de DJs confirmados")
public record EventoResponseDTO(

        @Schema(description = "ID único do evento no banco de dados", example = "1")
        Long id,

        @Schema(description = "Nome do evento", example = "Tomorrowland Brasil")
        String evento,

        @Schema(description = "Local onde ocorrerá o evento", example = "Parque Maeda, Itu - SP")
        String local,

        @Schema(description = "Duração do evento em horas", example = "72")
        int duracao,

        @Schema(description = "Lista com os nomes dos DJs confirmados para este evento", example = "[\"Alok\", \"Vintage Culture\"]")
        List<String> djs
) { }
