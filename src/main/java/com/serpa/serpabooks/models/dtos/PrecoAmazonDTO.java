package com.serpa.serpabooks.models.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrecoAmazonDTO {

	private Long id;
	private Float preco;
	private String img;
	private String link;
	private LocalDateTime dataCadastro;
	private CapaDTO capa;
	@JsonIgnore
	private LivroDTO livro;

}