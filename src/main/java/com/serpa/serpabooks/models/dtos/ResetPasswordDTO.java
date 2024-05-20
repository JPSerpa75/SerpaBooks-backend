package com.serpa.serpabooks.models.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResetPasswordDTO {

	private String emailUsuario;
	private String nomeUsuario;
	private LocalDate dataNascimentoUsuario;
	private String novaSenha;

}
