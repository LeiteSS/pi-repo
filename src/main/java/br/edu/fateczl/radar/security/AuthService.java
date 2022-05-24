package br.edu.fateczl.radar.security;

import br.edu.fateczl.radar.model.Usuario;
import br.edu.fateczl.radar.repository.UsuariosRepository;
import br.edu.fateczl.radar.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    /*@Autowired
    private UsuariosService usersService;*/

    @Autowired
    private UsuariosRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usersRepository.findByEmail(username);

        if (user == null) {
            user = usersRepository.findByUsername(username);
        }

        if (!validUser(user)) {
            throw new UsernameNotFoundException("Usuario sem permissão");
        }

        return user;
    }

    private boolean validUser(Usuario user) {
        boolean validUser = false;

        if (user != null && user.getRoles() != null) {
            validUser = true;
        }

        return validUser;
    }
}
