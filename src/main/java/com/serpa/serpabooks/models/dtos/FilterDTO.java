package com.serpa.serpabooks.models.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterDTO {

	private String textoChave;
	private List<Long> idsEditoras;
	private List<Long> idsAutores;
	private Integer pageNumber;
	private Integer pageSize;

}
