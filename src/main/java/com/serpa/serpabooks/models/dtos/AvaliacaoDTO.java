package com.serpa.serpabooks.models.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvaliacaoDTO {

	private Long id;
	private String descricaoAvaliacao;
	private LocalDateTime dataAvaliacao;
	private Float valorAvaliacao;
	private UsuarioDTO usuario;
	@JsonIgnore
	private InfoLivroDTO infoLivro;

}
