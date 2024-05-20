package com.serpa.serpabooks.models.dtos;

import java.time.LocalDateTime;

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
	private Long idInfoLivro;
//	@JsonIgnore
//	private InfoLivroDTO infoLivro;

}
