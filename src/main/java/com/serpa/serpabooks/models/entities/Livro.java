package com.serpa.serpabooks.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "LIVRO")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LIVRO")
	private Long id;

	@Column(name = "URL_IMAGEM_LIVRO")
	private String urlImagem;

	@Column(name = "NUMERO_PAGINAS_LIVRO")
	private Integer numeroPaginas;

	@Column(name = "ISBN_10_LIVRO")
	private String isbn10;

	@Column(name = "ISBN_13_LIVRO")
	private String isbn13;

	@Column(name = "DT_PUBLICACAO_LIVRO")
	private LocalDate dataPublicacao;

	@Column(name = "DT_CADASTRO_LIVRO")
	private LocalDateTime dataCadastro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EDITORA", nullable = false)
	private Editora editora;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CAPA", nullable = false)
	private Capa capa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_INFO_LIVRO", nullable = false)
	private InfoLivro infoLivro;

	public Livro(Long idLivro) {
		this.setId(idLivro);
	}
	
}
