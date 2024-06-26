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
@Table(name = "AVALIACAO")
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AVALIACAO")
	private Long id;

	@Column(name = "DS_AVALIACAO")
	private String descricaoAvaliacao;

	@Column(name = "DT_AVALIACAO")
	private LocalDateTime dataAvaliacao;

	@Column(name = "VALOR_AVALIACAO")
	private Float valorAvaliacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_INFO_LIVRO", nullable = false)
	private InfoLivro infoLivro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO", nullable = false)
	private Usuario usuario;

}
