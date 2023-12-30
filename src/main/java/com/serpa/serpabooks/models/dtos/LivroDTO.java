package com.serpa.serpabooks.models.dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LivroDTO {

	private Long id;
	private String titulo;
	private Float notaLivro;
	private String urlImagem;
	private Integer numeroPaginas;
	private String idioma;
	private String isbn10;
	private String isbn13;
	private String resumo;
	private String sinopse;
	private LocalDateTime dataPublicacao;
	private LocalDateTime dataCadastro;
	private AutorDTO autor;
	private EditoraDTO editora;
	private CapaDTO capa;
	private List<AvaliacaoDTO> avaliacoes;

}
