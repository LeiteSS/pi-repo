package br.edu.fateczl.radar.service;

import br.edu.fateczl.radar.dto.DesaparecidoDTO;
import br.edu.fateczl.radar.mapper.DesaparecidosMapper;
import br.edu.fateczl.radar.model.Desaparecido;
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
        Long userId = tokenService.getUserId(token);
        Usuario user = usuariosRepository.getById(userId);
        desaparecido.setUsuario(user);
        Desaparecido desaparecidoSaved = desaparecidosRepository.save(desaparecido);

        return mapper.toDTO(desaparecidoSaved);
    }

    public List<Desaparecido> listLoans() {

        return desaparecidosRepository.findAll();
    }

    public Optional<Desaparecido> detailLoan(Long id) {

        return desaparecidosRepository.findById(id);
    }
}
