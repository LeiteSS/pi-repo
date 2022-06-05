package br.edu.fateczl.radar.controller;

import br.edu.fateczl.radar.controller.docs.DesaparecidosControllerDocs;

import br.edu.fateczl.radar.dto.DesaparecidoDTO;
import br.edu.fateczl.radar.model.Desaparecido;
import br.edu.fateczl.radar.service.DesaparecidosService;
import br.edu.fateczl.radar.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/v1/desaparecidos")
public class DesaparecidosController implements DesaparecidosControllerDocs {

    @Autowired
    private DesaparecidosService service;

    @Override
    public ResponseEntity<DesaparecidoDTO> create(DesaparecidoDTO desaparecidoDTO, HttpServletRequest request) throws Exception {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(service.createDesaparecido(desaparecidoDTO, token));
    }

    @Override
    public ResponseEntity<List<Desaparecido>> listDesaparecidos() {
        return ResponseEntity.ok(service.list());
    }

    //@Override
    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.detailDesaparecido(id));
    }

}
