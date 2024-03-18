package com.serpa.serpabooks.models.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EditoraDTO {

	private Long id;
	private String nomeEditora;
	@JsonIgnore
	private List<LivroDTO> livros;

}
