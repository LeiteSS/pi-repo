package br.edu.fateczl.radar.service;

import br.edu.fateczl.radar.dto.DesaparecidoDTO;
import br.edu.fateczl.radar.mapper.DesaparecidosMapper;
import br.edu.fateczl.radar.model.Desaparecido;
import br.edu.fateczl.radar.model.Foto;
import br.edu.fateczl.radar.model.Usuario;
import br.edu.fateczl.radar.repository.DesaparecidosRepository;
import br.edu.fateczl.radar.repository.UsuariosRepository;
import br.edu.fateczl.radar.security.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DesaparecidosService {

    private DesaparecidosRepository desaparecidosRepository;

    private TokenService tokenService;

    private UsuariosRepository usuariosRepository;

    private DesaparecidosMapper mapper;

    public DesaparecidoDTO createDesaparecido(DesaparecidoDTO loanDTO, String token) throws Exception {
        Desaparecido desaparecido = new Desaparecido();
        Foto foto = new Foto();

        Long userId = tokenService.getUserId(token);
        Usuario user = usuariosRepository.getById(userId);
        desaparecido.setUsuario(user);
        desaparecido.setDescricaoDesaparecimento(loanDTO.getDescricaoDesaparecimento());
        desaparecido.setNomeCompletoDesaparecido(loanDTO.getNomeCompletoDesaparecido());
        desaparecido.setDescricaoDesaparecimento(loanDTO.getDescricaoDesaparecimento());
        desaparecido.setDataEHoraDesaparecimento(loanDTO.getDataEHoraDesaparecimento());
        desaparecido.setAltTxtFotoPrincipal(loanDTO.getAltTxtFotoPrincipal());
        desaparecido.setUrlFotoPrincipal(loanDTO.getUrlFotoPrincipal());
        desaparecido.setDataDeNascimento(loanDTO.getDataDeNascimento());
        desaparecido.setRecompensa(loanDTO.getRecompensa());
        desaparecido.setDataDeNascimento(loanDTO.getDataDeNascimento());
        desaparecido.setFotos(loanDTO.getFotos());

        desaparecidosRepository.save(desaparecido);

        return loanDTO;
    }

    public List<Desaparecido> list() {

        return desaparecidosRepository.findAll();
    }

    public Optional<Desaparecido> detailDesaparecido(Long id) {

        return desaparecidosRepository.findById(id);
    }
}
