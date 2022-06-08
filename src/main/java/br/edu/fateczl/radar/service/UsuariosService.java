package br.edu.fateczl.radar.service;

import br.edu.fateczl.radar.dto.LoginDTO;
import br.edu.fateczl.radar.dto.SignupDTO;
import br.edu.fateczl.radar.dto.TokenDTO;
import br.edu.fateczl.radar.mapper.UsuariosMapper;
import br.edu.fateczl.radar.entity.Usuario;
import br.edu.fateczl.radar.repository.UsuariosRepository;
import br.edu.fateczl.radar.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuariosService {

    private UsuariosRepository usuariosRepository;
    private UsuariosMapper mapper;
    private TokenService tokenService;
    private AuthenticationManager authenticationManager;

    public SignupDTO signUp(SignupDTO profileInformationDTO) {
        String pwd = profileInformationDTO.getPassword();
        profileInformationDTO.setPassword(new BCryptPasswordEncoder().encode(pwd));

        Usuario user = mapper.toModel(profileInformationDTO);

        Usuario userSaved = usuariosRepository.save(user);

        return mapper.toDTO(userSaved);
    }

    public TokenDTO signIn(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken loginData = loginDTO.convert();
        Authentication auth = authenticationManager.authenticate(loginData);
        String token = tokenService.getToken(auth);

        return new TokenDTO(token, "Bearer");
    }
}
