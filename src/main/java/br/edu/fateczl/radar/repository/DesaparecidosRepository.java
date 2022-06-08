package br.edu.fateczl.radar.repository;

import br.edu.fateczl.radar.entity.Desaparecido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesaparecidosRepository extends JpaRepository<Desaparecido, Long> {
}
