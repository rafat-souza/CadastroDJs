package com.rafael.CadastroDJs.documentation;

import com.rafael.CadastroDJs.DTOs.request.EventoRequestDTO;
import com.rafael.CadastroDJs.DTOs.response.EventoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Eventos", description = "Gerenciamento de eventos do sistema")
public interface EventoControllerDoc {

    // Resgatar todos
    @Operation(summary = "Resgatar todos os eventos", description = "Retorna todos os eventos cadastrados na base de dados")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    public ResponseEntity<List<EventoResponseDTO>> getAll();

    // Resgatar um
    @Operation(summary = "Resgatar evento", description = "Resgata um único evento da base através do id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Evento buscado não foi encontrado")
    })
    public ResponseEntity<EventoResponseDTO> get(
            @Parameter(description = "id do evento", example = "1") @PathVariable Long id
    );

    // Cadastrar
    @Operation(summary = "Cadastrar novo evento", description = "Cria um novo evento para a base de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Evento cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados (ex: nome vazio)")
    })
    public ResponseEntity<EventoResponseDTO> create(
            @Parameter(description = "Atributos do novo evento") @RequestBody EventoRequestDTO request
            );

    // Atualizar
    @Operation(summary = "Atualizar evento", description = "Atualiza os dados/atributos de um evento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados (ex: nome vazio)"),
            @ApiResponse(responseCode = "404", description = "Evento buscado não foi encontrado")
    })
    public ResponseEntity<EventoResponseDTO> update(
            @Parameter(description = "id do evento a ser atualizado") @PathVariable Long id,
            @Parameter(description = "Novos dados do evento") @RequestBody EventoRequestDTO request
    );

    // Deletar
    @Operation(summary = "Remover evento", description = "Remove evento permanentemente da base de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Evento excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Evento não foi encontrado")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "id do evento a ser deletado") @PathVariable Long id
    );
}
