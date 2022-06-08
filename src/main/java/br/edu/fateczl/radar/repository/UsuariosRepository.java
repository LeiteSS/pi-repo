package br.edu.fateczl.radar.repository;

import br.edu.fateczl.radar.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{

    @Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.username = (:username)")
    public Usuario findByUsername(@Param("username") String username);

    @Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.email = (:email)")
    public Usuario findByEmail(@Param("email") String email);
}
