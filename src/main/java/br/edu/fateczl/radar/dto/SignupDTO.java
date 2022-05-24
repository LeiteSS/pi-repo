package br.edu.fateczl.radar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupDTO {

    @NotNull
    @ApiModelProperty(value = "Username")
    private String username;

    @Size(min = 8, message = "A senha deve ter no minimo 8 caracteres.")
    @NotNull
    @ApiModelProperty(value = "Senha")
    private String password;

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

    @CPF
    @NotNull
    @ApiModelProperty(value = "CPF")
    private String cpf;

    @Size(min = 9, max = 9, message = "O Registro Geral (R.G.) deve ser valido.")
    @NotNull
    @ApiModelProperty(value = "RG")
    private String rg;

    @ApiModelProperty(value = "Papeis ou funções: USERS, Volunteers ou MANAGERS")
    private List<String> roles;
}
