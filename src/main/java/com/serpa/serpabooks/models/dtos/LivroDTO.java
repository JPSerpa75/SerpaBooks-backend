package com.serpa.serpabooks.models.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LivroDTO {

	private Long id;
	private String urlImagem;
	private Integer numeroPaginas;
	private String isbn10;
	private String isbn13;
	private LocalDate dataPublicacao;
	private LocalDateTime dataCadastro;
	private EditoraDTO editora;
	private CapaDTO capa;
	@JsonIgnore
	private InfoLivroDTO infoLivro;

}
