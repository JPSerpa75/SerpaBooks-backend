package com.serpa.serpabooks.models.entities;

import java.io.Serializable;
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
@Table(name = "INFO_LIVRO")
public class InfoLivro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_INFO_LIVRO")
	private Long id;

	@Column(name = "TITULO_LIVRO")
	private String titulo;

	@Column(name = "NOTA_LIVRO")
	private Float notaLivro;

	@Column(name = "IDIOMA_LIVRO")
	private String idioma;

	@Column(name = "RESUMO_LIVRO", length = 500)
	private String resumo;

	@Column(name = "SINOPSE_LIVRO", length = 5000)
	private String sinopse;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AUTOR", nullable = false)
	private Autor autor;

	@OneToMany(mappedBy = "infoLivro", fetch = FetchType.LAZY)
	private List<Avaliacao> avaliacoes;

	@OneToMany(mappedBy = "infoLivro", fetch = FetchType.LAZY)
	private List<Livro> livros;
	
}
