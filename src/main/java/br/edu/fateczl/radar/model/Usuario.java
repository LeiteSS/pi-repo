package br.edu.fateczl.radar.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, name = "senha")
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, name = "nome")
    private String name;

    @Column(nullable = false, name = "sobrenome")
    private String lastname;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "roles_id")
    private List<String> roles;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Desaparecido> desaparecidos;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authoritiesList = Arrays.asList(new SimpleGrantedAuthority(roles.stream().toString()));

        return authoritiesList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
