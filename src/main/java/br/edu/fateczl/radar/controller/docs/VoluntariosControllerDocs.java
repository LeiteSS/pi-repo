package br.edu.fateczl.radar.controller.docs;

import br.edu.fateczl.radar.dto.CadastroVoluntarioDTO;
import br.edu.fateczl.radar.dto.ErrorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(value = "/api/v1/voluntarios",  description = "Operações relacionadas aos Voluntarios")
public interface VoluntariosControllerDocs {

    @ApiOperation(value = "Cadastrar um voluntario", nickname = "create", notes = "", response = CadastroVoluntarioDTO.class, responseContainer = "object", tags = { "Users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Voluntarios Cadastrado no sistema", response = CadastroVoluntarioDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object")})
    @PostMapping
    public ResponseEntity<CadastroVoluntarioDTO> create(@RequestBody @Valid CadastroVoluntarioDTO profileInformationDTO);
}
