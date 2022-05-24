package br.edu.fateczl.radar.controller.docs;

import br.edu.fateczl.radar.dto.ErrorDTO;
import br.edu.fateczl.radar.dto.LoginDTO;
import br.edu.fateczl.radar.dto.SignupDTO;
import br.edu.fateczl.radar.dto.TokenDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(value = "/api/v1/usuarios",  description = "Operações relacionadas aos Usuarios")
public interface UsuariosControllerDocs {

    @ApiOperation(value = "Cadastrar um usuario", nickname = "signUp", notes = "", response = SignupDTO.class, responseContainer = "object", tags = { "Users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Cadastrado no sistema", response = SignupDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object")})
    @PostMapping("/signUp")
    public ResponseEntity<SignupDTO> signUp(@RequestBody @Valid SignupDTO profileInformationDTO);

    @ApiOperation(value = "Logar no sistema", nickname = "signIn", notes = "", response = TokenDTO.class, responseContainer = "object", tags = { "Users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Logado com sucesso!", response = TokenDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping("/signIn")
    public ResponseEntity<TokenDTO> signIn(@RequestBody @Valid LoginDTO loginDTO);
}
