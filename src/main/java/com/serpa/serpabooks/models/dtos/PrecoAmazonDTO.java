package com.serpa.serpabooks.models.dtos;

import java.time.LocalDateTime;

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

}
