package com.rafael.CadastroDJs.DTOs.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Objeto de requisição contendo os dados para criação ou atualização de um DJ")
public record DJRequestDTO(

        @Schema(description = "Nome artístico do DJ", example = "Alok")
        @NotBlank
        String dj,

        @Schema(description = "Gravadora ou selo principal do DJ", example = "Spinnin' Records")
        String label,

        @Schema(description = "Idade atual do DJ", example = "32")
        int idade,

        @Schema(description = "E-mail para contato profissional", example = "contato@alok.com")
        @NotBlank
        String email,

        @Schema(description = "ID único do evento ao qual o DJ será vinculado", example = "1")
        @NotNull
        Long eventoId
) { }
