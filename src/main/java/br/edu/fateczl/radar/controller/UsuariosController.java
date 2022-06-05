package br.edu.fateczl.radar.controller;

import br.edu.fateczl.radar.controller.docs.UsuariosControllerDocs;
import br.edu.fateczl.radar.dto.LoginDTO;
import br.edu.fateczl.radar.dto.SignupDTO;
import br.edu.fateczl.radar.dto.TokenDTO;
import br.edu.fateczl.radar.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/v1/usuarios")
public class UsuariosController implements UsuariosControllerDocs {

    @Autowired
    private UsuariosService service;

    @Override
    public ResponseEntity<SignupDTO> signUp(@RequestBody @Valid SignupDTO profileInformationDTO) {

        SignupDTO responseBody = service.signUp(profileInformationDTO);

        return ResponseEntity.ok(responseBody);
    }

    @Override
    public ResponseEntity<TokenDTO> signIn(@RequestBody @Valid LoginDTO loginDTO) {
        return ResponseEntity.ok(service.signIn(loginDTO));
    }
}
