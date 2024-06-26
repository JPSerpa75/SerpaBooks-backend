package com.serpa.serpabooks.models.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CapaDTO {

	private Long id;
	private String descricaoCapa;
	@JsonIgnore
	private List<LivroDTO> livros;
}
