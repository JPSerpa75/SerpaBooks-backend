package com.serpa.serpabooks.models.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InfoLivroDTO {

	private Long id;
	private String titulo;
	private Float notaLivro;
	private String idioma;
	private String resumo;
	private String sinopse;
	private AutorDTO autor;
	private List<AvaliacaoDTO> avaliacoes;
	@JsonIgnore
	private List<LivroDTO> livros;

}
