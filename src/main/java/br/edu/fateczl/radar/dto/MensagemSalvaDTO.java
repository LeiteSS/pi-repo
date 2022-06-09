package br.edu.fateczl.radar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.br.CPF;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MensagemSalvaDTO {

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

    @Email(message = "Insira um email valido")
    @Pattern(regexp=".+@.+\\..+", message="Insira um email valido")
    @NotNull
    @ApiModelProperty(value = "Email")
    private String email;

    @NotNull
    @ApiModelProperty(value = "Nome")
    private String name;

    @NotNull
    @ApiModelProperty(value = "Sobrenome")
    private String lastname;

    @NotNull
    @ApiModelProperty(value = "Telefone")
    private String phone;

    @CPF
    @NotNull
    @ApiModelProperty(value = "CPF")
    private String cpf;

    @NotNull
    @ApiModelProperty(value = "mensagem")
    private String mensagem;
}
