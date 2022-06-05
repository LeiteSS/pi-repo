package br.edu.fateczl.radar.dto;

import br.edu.fateczl.radar.model.Foto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.annotations.ApiModelProperty;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DesaparecidoDTO {

    @NotNull
    @ApiModelProperty(value = "Data e Hora do Desaparecimento")
    private String dataEHoraDesaparecimento;

    @NotNull
    @ApiModelProperty(value = "Nome completo")
    private String nomeCompletoDesaparecido;

    @NotNull
    @ApiModelProperty(value = "Data de nascimento")
    private String dataDeNascimento;

    @NotNull
    @ApiModelProperty(value = "recompensa")
    private String recompensa;

    @NotNull
    @ApiModelProperty(value = "Url da Foto Principal")
    private String urlFotoPrincipal;

    @NotNull
    @ApiModelProperty(value = "Texto Alternativo da foto principal")
    private String altTxtFotoPrincipal;

    @NotNull
    @ApiModelProperty(value = "Descrição do Desaparecimento")
    private String descricaoDesaparecimento;


    @ApiModelProperty(value = "urls das fotos secundarias")
    private List<String> fotos;
}
