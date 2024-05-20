package com.serpa.serpabooks.models.dtos;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.serpa.serpabooks.models.enums.UserRoleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {

	private Long id;
	private String email;
	private String senha;
	private String nomeUsuario;
	private LocalDate dataNascimento;
	private UserRoleEnum role;
	@JsonIgnore
	private List<AvaliacaoDTO> avaliacoes;
}
