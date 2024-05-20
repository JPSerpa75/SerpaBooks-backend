package com.serpa.serpabooks.models.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InfoLivroGridDTO {

	private Long idInfoLivro;
	private String tituloLivro;
	private Float notaLivro;
	private String idioma;
	private String resumo;
	private String sinopse;
	private String descricaoCapa;
	private String nomeEditora;
	private String urlImagem;
	private LocalDate dataPublicacao;
	private String nomeAutor;

}
