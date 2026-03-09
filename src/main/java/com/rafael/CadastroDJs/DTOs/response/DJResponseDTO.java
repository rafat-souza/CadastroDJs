package com.rafael.CadastroDJs.DTOs.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta contendo os dados detalhados de um DJ")
public record DJResponseDTO(

        @Schema(description = "ID único do DJ no banco de dados", example = "1")
        Long id,

        @Schema(description = "Nome artístico do DJ", example = "Alok")
        String dj,

        @Schema(description = "Gravadora ou selo principal do DJ", example = "Spinnin' Records")
        String label,

        @Schema(description = "Idade atual do DJ", example = "32")
        int idade,

        @Schema(description = "E-mail para contato profissional", example = "contato@alok.com")
        String email,

        @Schema(description = "ID único do evento ao qual o DJ está vinculado", example = "5")
        Long eventoId,

        @Schema(description = "Nome do evento ao qual o DJ está vinculado", example = "Tomorrowland Brasil")
        String nomeEvento
) { }
