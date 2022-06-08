package br.edu.fateczl.radar.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fateczl.radar.entity.Usuario;
import br.edu.fateczl.radar.repository.UsuariosRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuariosRepository usuariosRepository;

    public JwtFilter(TokenService tokenService, UsuariosRepository usuariosRepository) {
        this.tokenService = tokenService;
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = recoverToken(request);

        boolean isValid = tokenService.isTokenValid(token);

        if (isValid) {
            authClient(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authClient(String token) {
        Long userId = tokenService.getUserId(token);
        Usuario user = usuariosRepository.findById(userId).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getRoles(), user,
                null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recoverToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }

    private List<SimpleGrantedAuthority> authorities(List<String> roles){
        return roles.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
