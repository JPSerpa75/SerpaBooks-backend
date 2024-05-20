package com.serpa.serpabooks.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PRECO_MERCADO_LIVRE")
public class PrecoMercadoLivre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRECO_MERCADO_LIVRE")
	private Long id;

	@Column(name = "PRECO_MERCADO_LIVRE")
	private Float preco;

	@Column(name = "IMG_MERCADO_LIVRE")
	private String img;

	@Column(name = "LINK_MERCADO_LIVRE")
	private String link;

	@Column(name = "DT_CADASTRO_MERCADO_LIVRE")
	private LocalDateTime dataCadastro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LIVRO", nullable = false)
	private Livro livro;

}
