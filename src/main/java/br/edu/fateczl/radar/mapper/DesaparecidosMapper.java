package br.edu.fateczl.radar.mapper;

import br.edu.fateczl.radar.dto.DesaparecidoDTO;
import br.edu.fateczl.radar.entity.Desaparecido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DesaparecidosMapper {

    DesaparecidosMapper INSTANCE = Mappers.getMapper(DesaparecidosMapper.class);

    Desaparecido toModel(DesaparecidoDTO dto);

    DesaparecidoDTO toDTO(Desaparecido model);
}
