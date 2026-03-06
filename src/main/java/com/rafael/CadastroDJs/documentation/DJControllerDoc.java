package com.rafael.CadastroDJs.documentation;

import com.rafael.CadastroDJs.DTOs.request.DJRequestDTO;
import com.rafael.CadastroDJs.DTOs.response.DJResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "DJs", description = "Gerenciamento de djs do sistema")
public interface DJControllerDoc {

    // Resgatar todos
    @Operation(summary = "Resgatar todos os DJs", description = "Retorna uma lista paginada dos DJs ativos")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    public ResponseEntity<List<DJResponseDTO>> getAll();

    // Resgatar único
    @Operation(summary = "Resgatar um DJ", description = "Resgata um dj em específico pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dj não foi encontrado")
    })
    public ResponseEntity<DJResponseDTO> get(
            @Parameter(description = "id do dj a ser buscado", example = "1") @PathVariable Long id
    );

    // Criar
    @Operation(summary = "Cadastrar novo DJ", description = "Cria um novo Dj e o vincula a um evento existente através do eventoId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "DJ criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados (ex: nome vazio, email inválido)"),
            @ApiResponse(responseCode = "404", description = "Evento referenciado não foi encontrado")
    })
    public ResponseEntity<DJResponseDTO> create(
            @Parameter(description = "Dados do novo DJ") @RequestBody DJRequestDTO request
    );

    // Atualizar
    @Operation(summary = "Atualizar DJ", description = "Atualiza os dados de um DJ já existente na base de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "DJ atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados (ex: nome vazio, email inválido)"),
            @ApiResponse(responseCode = "404", description = "DJ ou evento referenciado não foi encontrado")
    })
    public ResponseEntity<DJResponseDTO> update(
            @Parameter(description = "id do DJ a ser atualizado", example = "1") @PathVariable Long id,
            @Parameter(description = "Novos dados do DJ") @RequestBody DJRequestDTO request
    );

    // Deletar
    @Operation(summary = "Deletar DJ", description = "Remove permanentemente um DJ existente da base de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "DJ excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum DJ com o id inserido foi encontrado")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "id do DJ a ser deletado", example = "1") @PathVariable Long id
    );
}
