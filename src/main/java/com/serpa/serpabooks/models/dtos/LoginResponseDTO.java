package com.serpa.serpabooks.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponseDTO {

	private String token;
	private String role;
	private String nomeUsuario;
}
