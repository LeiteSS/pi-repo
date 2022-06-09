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
public class MensagemDTO {

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
