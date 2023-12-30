package com.serpa.serpabooks.models.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.serpa.serpabooks.models.enums.UserRoleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {

	private Long id;
	private String login;
	private String senha;
	private String nomeUsuario;
	private LocalDateTime dataNascimento;
	private UserRoleEnum role;
	private List<AvaliacaoDTO> avaliacoes;
}
