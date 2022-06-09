package br.edu.fateczl.radar.controller;

import br.edu.fateczl.radar.controller.docs.DesaparecidosControllerDocs;

import br.edu.fateczl.radar.dto.DesaparecidoDTO;
import br.edu.fateczl.radar.dto.MensagemDTO;
import br.edu.fateczl.radar.dto.MensagemSalvaDTO;
import br.edu.fateczl.radar.entity.Desaparecido;
import br.edu.fateczl.radar.entity.Mensagem;
import br.edu.fateczl.radar.exception.NotFoundException;
import br.edu.fateczl.radar.service.DesaparecidosService;
import br.edu.fateczl.radar.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:4200/", "https://radar-client.netlify.app/" })
@RequestMapping("/api/v1/desaparecidos")
public class DesaparecidosController implements DesaparecidosControllerDocs {

    @Autowired
    private DesaparecidosService service;

    @Override
    @PostMapping
    public ResponseEntity<DesaparecidoDTO> create(DesaparecidoDTO desaparecidoDTO, HttpServletRequest request) throws Exception {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(service.createDesaparecido(desaparecidoDTO, token));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Desaparecido>> listDesaparecidos() {
        return ResponseEntity.ok(service.list());
    }

    @Override
    @PutMapping("/{id}")
    public DesaparecidoDTO updateById(@PathVariable Long id, @RequestBody @Valid  DesaparecidoDTO desaparecidoDTO, HttpServletRequest request) throws NotFoundException {
        String token = TokenUtils.wrapperToken(request);

        return service.updateById(id, desaparecidoDTO, token);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(Long id) throws NotFoundException {
        service.deleteById(id);
    }

    @Override
    @PostMapping("/{id}/mensagem")
    public ResponseEntity<MensagemSalvaDTO> reportar(Long id,MensagemDTO mensagemDTO) throws Exception {
        return ResponseEntity.ok(service.reportar(id, mensagemDTO));
    }

    @Override
    @GetMapping("/mensagem")
    public List<Mensagem> listMensagens() {
        return service.listarMensagens();
    }

    //@Override
    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.detailDesaparecido(id));
    }

}
