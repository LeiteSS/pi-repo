package br.edu.fateczl.radar.mapper;

import br.edu.fateczl.radar.dto.CadastroVoluntarioDTO;
import br.edu.fateczl.radar.entity.Voluntario;
import org.mapstruct.factory.Mappers;

public interface VoluntariosMapper {

    VoluntariosMapper INSTANCE = Mappers.getMapper(VoluntariosMapper.class);

    Voluntario toModel(CadastroVoluntarioDTO dto);

    CadastroVoluntarioDTO toDTO(Voluntario model);
}
