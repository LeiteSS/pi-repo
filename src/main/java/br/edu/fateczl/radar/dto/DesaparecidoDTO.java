package br.edu.fateczl.radar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.annotations.ApiModelProperty;


import javax.validation.constraints.NotNull;
import java.util.List;

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

    @NotNull
    @ApiModelProperty(value = "Se possui alguma doença")
    private String doenca;

    @NotNull
    @ApiModelProperty(value = "Sexo: masculino, feminino ou outros")
    private String sexo;

    @NotNull
    @ApiModelProperty(value = "Cor de pele")
    private String corDePele;

    @ApiModelProperty(value = "urls das fotos secundarias")
    private List<String> fotos;

    @NotNull
    @ApiModelProperty(value = "Logradouro")
    private String logradouro;

    @NotNull
    @ApiModelProperty(value = "Bairro")
    private String bairro;

    @NotNull
    @ApiModelProperty(value = "Cidade")
    private String cidade;

    @NotNull
    @ApiModelProperty(value = "CEP")
    private String cep;
}
