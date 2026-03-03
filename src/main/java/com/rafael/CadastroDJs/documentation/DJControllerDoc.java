package com.rafael.CadastroDJs.documentation;

import com.rafael.CadastroDJs.models.DJModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "DJs", description = "Gerenciamento de djs do sistema")
public interface DJControllerDoc {

    @Operation(summary = "Resgatar todos os DJs", description = "Retorna uma lista paginada dos DJs ativos")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    public List<DJModel> getAll();

    @Operation(summary = "Resgata um DJ", description = "Resgata um dj em específico pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dj não existe na base de dados")
    })
    public ResponseEntity<DJModel> get(
            @Parameter(description = "id do dj a ser buscado", example = "1") Long id
    );
}
