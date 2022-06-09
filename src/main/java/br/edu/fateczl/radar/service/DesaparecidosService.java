package br.edu.fateczl.radar.service;

import br.edu.fateczl.radar.dto.DesaparecidoDTO;
import br.edu.fateczl.radar.dto.MensagemDTO;
import br.edu.fateczl.radar.dto.MensagemSalvaDTO;
import br.edu.fateczl.radar.entity.*;
import br.edu.fateczl.radar.exception.NotFoundException;
import br.edu.fateczl.radar.mapper.DesaparecidosMapper;
import br.edu.fateczl.radar.repository.DesaparecidosRepository;
import br.edu.fateczl.radar.repository.EnderecoRepository;
import br.edu.fateczl.radar.repository.MensagensRepository;
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

    private EnderecoRepository addressesRepository;

    private MensagensRepository mensagensRepository;

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

    public List<Mensagem> listarMensagens() {
        return mensagensRepository.findAll();
    }


    public MensagemSalvaDTO reportar(Long id, MensagemDTO mensagemDTO) throws NotFoundException {
        Mensagem mensagem = new Mensagem();
        MensagemSalvaDTO mensagemSalvaDTO = new MensagemSalvaDTO();

        Desaparecido desaparecido = verifyIfExists(id);

        mensagem.setIdDesaparecido(desaparecido.getId());
        mensagem.setMensagem(mensagemDTO.getMensagem());
        mensagem.setCpf(mensagemDTO.getCpf());
        mensagem.setEmail(mensagemDTO.getEmail());
        mensagem.setName(mensagemDTO.getName());
        mensagem.setLastname(mensagemDTO.getLastname());
        mensagem.setPhone(mensagemDTO.getPhone());

        Mensagem mensagemSalva = mensagensRepository.save(mensagem);

        mensagemSalvaDTO.setMensagem(mensagemSalva.getMensagem());
        mensagemSalvaDTO.setDescricaoDesaparecimento(desaparecido.getDescricaoDesaparecimento());
        mensagemSalvaDTO.setNomeCompletoDesaparecido(desaparecido.getNomeCompletoDesaparecido());
        mensagemSalvaDTO.setDescricaoDesaparecimento(desaparecido.getDescricaoDesaparecimento());
        mensagemSalvaDTO.setDataEHoraDesaparecimento(desaparecido.getDataEHoraDesaparecimento());
        mensagemSalvaDTO.setAltTxtFotoPrincipal(desaparecido.getAltTxtFotoPrincipal());
        mensagemSalvaDTO.setUrlFotoPrincipal(desaparecido.getUrlFotoPrincipal());
        mensagemSalvaDTO.setDataDeNascimento(desaparecido.getDataDeNascimento());
        mensagemSalvaDTO.setRecompensa(desaparecido.getRecompensa());
        mensagemSalvaDTO.setDataDeNascimento(desaparecido.getDataDeNascimento());
        mensagemSalvaDTO.setFotos(desaparecido.getFotos());
        mensagemSalvaDTO.setCorDePele(desaparecido.getCorDePele());
        mensagemSalvaDTO.setDoenca(desaparecido.getDoenca());
        mensagemSalvaDTO.setSexo(desaparecido.getSexo());
        mensagemSalvaDTO.setMensagem(mensagemDTO.getMensagem());
        mensagemSalvaDTO.setCpf(mensagem.getCpf());
        mensagemSalvaDTO.setEmail(mensagem.getEmail());
        mensagemSalvaDTO.setName(mensagem.getName());
        mensagemSalvaDTO.setLastname(mensagem.getLastname());
        mensagemSalvaDTO.setPhone(mensagem.getPhone());

        return mensagemSalvaDTO;
    }

    private Desaparecido verifyIfExists(Long id) throws NotFoundException {
        return desaparecidosRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

}
