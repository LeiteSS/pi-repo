package br.edu.fateczl.radar.controller;

import br.edu.fateczl.radar.controller.docs.VoluntariosControllerDocs;
import br.edu.fateczl.radar.dto.CadastroVoluntarioDTO;
import br.edu.fateczl.radar.service.VoluntariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/voluntarios")
public class VoluntariosController implements VoluntariosControllerDocs {

    @Autowired
    private VoluntariosService service;

    @Override
    public ResponseEntity<CadastroVoluntarioDTO> create(CadastroVoluntarioDTO profileInformationDTO) {
        CadastroVoluntarioDTO responseBody = service.signUp(profileInformationDTO);
        return ResponseEntity.ok(responseBody);
    }
}
