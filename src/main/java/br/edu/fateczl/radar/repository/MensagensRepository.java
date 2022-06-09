package br.edu.fateczl.radar.repository;

import br.edu.fateczl.radar.entity.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagensRepository extends JpaRepository<Mensagem, Long> {
}
