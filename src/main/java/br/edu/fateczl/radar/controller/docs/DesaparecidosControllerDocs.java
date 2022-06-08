package br.edu.fateczl.radar.controller.docs;

import br.edu.fateczl.radar.dto.DesaparecidoDTO;
import br.edu.fateczl.radar.dto.ErrorDTO;
import br.edu.fateczl.radar.entity.Desaparecido;
import br.edu.fateczl.radar.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Api(value = "/api/v1/desaparecidos",  description = "Operações relacionadas aos Desaparecidos")
public interface DesaparecidosControllerDocs {

    @ApiOperation(value = "Cadastrar um desaparecido", nickname = "createDesaparecido", notes = "", response = DesaparecidoDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Desaparecidos", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Desaparecido cadastrado", response = DesaparecidoDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    public ResponseEntity<DesaparecidoDTO> create(@Valid @RequestBody DesaparecidoDTO desaparecidoDTO, HttpServletRequest request) throws Exception;

    @ApiOperation(value = "Listar desaparecidos", nickname = "list", notes = "", response = Desaparecido.class, responseContainer = "object", tags = { "Desaparecidos", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Desaparecidos listados", response = Desaparecido.class, responseContainer = "object"),
            })
    public ResponseEntity<List<Desaparecido>> listDesaparecidos();

    @ApiOperation(value = "Atualizar desaparecido usando o id",authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Desaparecidos", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Desaparecido atualizado"),
            @ApiResponse(code = 400, message = "Campos vazios ou incorretos")
    })
    DesaparecidoDTO updateById(@PathVariable Long id, DesaparecidoDTO desaparecidoDTO, HttpServletRequest request) throws NotFoundException;

    @ApiOperation(value = "Deletar um desaparecido usando o id", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Desaparecidos", })
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Desaparecido deletado."),
            @ApiResponse(code = 404, message = "Desaparecido não encontrado.")
    })
    void deleteById(@PathVariable Long id) throws NotFoundException;

    /*@ApiOperation(value = "Detalhar desaparecido", nickname = "detail", notes = "", response = Desaparecido.class, responseContainer = "object", tags = { "Desaparecidos", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Desaparecido detalhado", response = Desaparecido.class, responseContainer = "object"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Desaparecido>> detailDesaparecido(@PathVariable Long id);*/
}
