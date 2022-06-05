package br.edu.fateczl.radar.service;

import br.edu.fateczl.radar.dto.CadastroVoluntarioDTO;
import br.edu.fateczl.radar.model.Endereco;
import br.edu.fateczl.radar.model.Voluntario;
import br.edu.fateczl.radar.repository.EnderecoRepository;
import br.edu.fateczl.radar.repository.VoluntariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class VoluntariosService {

    @Autowired
    private VoluntariosRepository voluntarioRepository;

    @Autowired
    private EnderecoRepository addressesRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public CadastroVoluntarioDTO signUp(CadastroVoluntarioDTO profileInformationDTO) {
        Voluntario user = new Voluntario();
        Endereco address = new Endereco();

        user.setEmail(profileInformationDTO.getEmail());
        user.setName(profileInformationDTO.getName());
        user.setLastname(profileInformationDTO.getLastname());
        user.setCpf(profileInformationDTO.getCpf());

        Voluntario userSaved = voluntarioRepository.save(user);

        address.setLogadouro(profileInformationDTO.getLogradouro());
        address.setBairro(profileInformationDTO.getBairro());
        address.setCep(profileInformationDTO.getCep());
        address.setCidade(profileInformationDTO.getCidade());
        address.setIdVoluntario(userSaved.getId());
        addressesRepository.save(address);

        return profileInformationDTO;
    }
}
