package com.serpa.serpabooks.models.dtos;

import java.time.LocalDate;

import com.serpa.serpabooks.models.enums.UserRoleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroDTO {

	private Long id;
	private String email;
	private String senha;
	private String nomeUsuario;
	private LocalDate dataNascimento;
	private UserRoleEnum role;

}
