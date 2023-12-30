package com.serpa.serpabooks.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvaliacaoDTO {

	private Long id;
	private Float valorAvaliacao;
	private Long idLivro;
	private Long idUsuario;

}
