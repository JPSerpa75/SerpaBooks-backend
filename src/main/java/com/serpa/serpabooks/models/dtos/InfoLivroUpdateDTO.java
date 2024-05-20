package com.serpa.serpabooks.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InfoLivroUpdateDTO {

	private Long id;
	private String resumo;
	private String sinopse;

}
