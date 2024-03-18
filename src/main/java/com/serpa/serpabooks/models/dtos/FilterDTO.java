package com.serpa.serpabooks.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterDTO {

	private String textoChave;
	private Integer pageNumber;
	private Integer pageSize;

}
