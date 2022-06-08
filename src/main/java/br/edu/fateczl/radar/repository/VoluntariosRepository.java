package br.edu.fateczl.radar.repository;

import br.edu.fateczl.radar.entity.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntariosRepository extends JpaRepository<Voluntario, Long> {
}
