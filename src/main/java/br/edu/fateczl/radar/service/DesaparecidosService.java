package br.edu.fateczl.radar.service;

import br.edu.fateczl.radar.dto.DesaparecidoDTO;
import br.edu.fateczl.radar.entity.Endereco;
import br.edu.fateczl.radar.exception.NotFoundException;
import br.edu.fateczl.radar.mapper.DesaparecidosMapper;
import br.edu.fateczl.radar.entity.Desaparecido;
import br.edu.fateczl.radar.entity.Foto;
import br.edu.fateczl.radar.entity.Usuario;
import br.edu.fateczl.radar.repository.DesaparecidosRepository;
import br.edu.fateczl.radar.repository.EnderecoRepository;
import br.edu.fateczl.radar.repository.UsuariosRepository;
import br.edu.fateczl.radar.security.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private EnderecoRepository addressesRepository;

    public DesaparecidoDTO createDesaparecido(DesaparecidoDTO desaparecidoDTO, String token) throws Exception {
        Desaparecido desaparecido = new Desaparecido();
        Endereco address = new Endereco();
        Foto foto = new Foto();

        Long userId = tokenService.getUserId(token);
        Usuario user = usuariosRepository.getById(userId);
        desaparecido.setUsuario(user);
        desaparecido.setDescricaoDesaparecimento(desaparecidoDTO.getDescricaoDesaparecimento());
        desaparecido.setNomeCompletoDesaparecido(desaparecidoDTO.getNomeCompletoDesaparecido());
        desaparecido.setDescricaoDesaparecimento(desaparecidoDTO.getDescricaoDesaparecimento());
        desaparecido.setDataEHoraDesaparecimento(desaparecidoDTO.getDataEHoraDesaparecimento());
        desaparecido.setAltTxtFotoPrincipal(desaparecidoDTO.getAltTxtFotoPrincipal());
        desaparecido.setUrlFotoPrincipal(desaparecidoDTO.getUrlFotoPrincipal());
        desaparecido.setDataDeNascimento(desaparecidoDTO.getDataDeNascimento());
        desaparecido.setRecompensa(desaparecidoDTO.getRecompensa());
        desaparecido.setDataDeNascimento(desaparecidoDTO.getDataDeNascimento());
        desaparecido.setFotos(desaparecidoDTO.getFotos());
        desaparecido.setCorDePele(desaparecidoDTO.getCorDePele());
        desaparecido.setDoenca(desaparecidoDTO.getDoenca());
        desaparecido.setSexo(desaparecidoDTO.getSexo());
        address.setLogadouro(desaparecidoDTO.getLogradouro());
        address.setBairro(desaparecidoDTO.getBairro());
        address.setCep(desaparecidoDTO.getCep());
        address.setCidade(desaparecidoDTO.getCidade());
        Desaparecido desaparecidoSalvo = desaparecidosRepository.save(desaparecido);
        address.setId(desaparecidoSalvo.getId());

        addressesRepository.save(address);

        return desaparecidoDTO;
    }

    public List<Desaparecido> list() {

        return desaparecidosRepository.findAll();
    }

    public Optional<Desaparecido> detailDesaparecido(Long id) {

        return desaparecidosRepository.findById(id);
    }

    public void deleteById(Long id) throws NotFoundException {
        verifyIfExists(id);
        desaparecidosRepository.deleteById(id);
    }

    public DesaparecidoDTO updateById(Long id, DesaparecidoDTO desaparecidoDTO, String token) throws NotFoundException {
        verifyIfExists(id);
        Desaparecido desaparecido = new Desaparecido();
        Endereco address = new Endereco();
        Foto foto = new Foto();

        Long userId = tokenService.getUserId(token);
        Usuario user = usuariosRepository.getById(userId);
        desaparecido.setUsuario(user);
        desaparecido.setId(id);
        desaparecido.setDescricaoDesaparecimento(desaparecidoDTO.getDescricaoDesaparecimento());
        desaparecido.setNomeCompletoDesaparecido(desaparecidoDTO.getNomeCompletoDesaparecido());
        desaparecido.setDescricaoDesaparecimento(desaparecidoDTO.getDescricaoDesaparecimento());
        desaparecido.setDataEHoraDesaparecimento(desaparecidoDTO.getDataEHoraDesaparecimento());
        desaparecido.setAltTxtFotoPrincipal(desaparecidoDTO.getAltTxtFotoPrincipal());
        desaparecido.setUrlFotoPrincipal(desaparecidoDTO.getUrlFotoPrincipal());
        desaparecido.setDataDeNascimento(desaparecidoDTO.getDataDeNascimento());
        desaparecido.setRecompensa(desaparecidoDTO.getRecompensa());
        desaparecido.setDataDeNascimento(desaparecidoDTO.getDataDeNascimento());
        desaparecido.setFotos(desaparecidoDTO.getFotos());
        desaparecido.setCorDePele(desaparecidoDTO.getCorDePele());
        desaparecido.setDoenca(desaparecidoDTO.getDoenca());
        desaparecido.setSexo(desaparecidoDTO.getSexo());

        address.setLogadouro(desaparecidoDTO.getLogradouro());
        address.setBairro(desaparecidoDTO.getBairro());
        address.setCep(desaparecidoDTO.getCep());
        address.setCidade(desaparecidoDTO.getCidade());
        address.setIdDesaparecido(id);

        addressesRepository.save(address);
        desaparecidosRepository.save(desaparecido);

        return desaparecidoDTO;
    }

    private Desaparecido verifyIfExists(Long id) throws NotFoundException {
        return desaparecidosRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

}
