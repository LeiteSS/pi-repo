package br.edu.fateczl.radar.mapper;

import br.edu.fateczl.radar.dto.SignupDTO;
import br.edu.fateczl.radar.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuariosMapper {

    UsuariosMapper INSTANCE = Mappers.getMapper(UsuariosMapper.class);

    Usuario toModel(SignupDTO dto);

    SignupDTO toDTO(Usuario model);
}
