package com.rafael.CadastroDJs.DTOs.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Objeto de requisição contendo os dados para criação ou atualização de um Evento")
public record EventoRequestDTO(

        @Schema(description = "Nome do evento", example = "Tomorrowland Brasil")
        @NotBlank
        String evento,

        @Schema(description = "Local onde ocorrerá o evento", example = "Parque Maeda, Itu - SP")
        String local,

        @Schema(description = "Duração do evento em horas", example = "72")
        @NotNull
        int duracao
) { }
