package com.serpa.serpabooks.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@Column(name = "TITULO_LIVRO")
	private String titulo;

	@Column(name = "NOTA_LIVRO")
	private Float notaLivro;

	@Column(name = "URL_IMAGEM_LIVRO")
	private String urlImagem;

	@Column(name = "NUMERO_PAGINAS_LIVRO")
	private Integer numeroPaginas;

	@Column(name = "IDIOMA_LIVRO")
	private String idioma;

	@Column(name = "ISBN_10_LIVRO")
	private String isbn10;

	@Column(name = "ISBN_13_LIVRO")
	private String isbn13;

	@Column(name = "RESUMO_LIVRO", length = 500)
	private String resumo;

	@Column(name = "SINOPSE_LIVRO", length = 5000)
	private String sinopse;

	@Column(name = "DT_PUBLICACAO_LIVRO")
	private LocalDateTime dataPublicacao;

	@Column(name = "DT_CADASTRO_LIVRO")
	private LocalDateTime dataCadastro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AUTOR", nullable = false)
	private Autor autor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EDITORA", nullable = false)
	private Editora editora;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CAPA", nullable = false)
	private Capa capa;

	@OneToMany(mappedBy = "livro", fetch = FetchType.LAZY)
	private List<Avaliacao> avaliacoes;

}
