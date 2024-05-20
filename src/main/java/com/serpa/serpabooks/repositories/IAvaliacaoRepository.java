package com.serpa.serpabooks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serpa.serpabooks.models.entities.Avaliacao;
import com.serpa.serpabooks.models.entities.InfoLivro;

public interface IAvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

	public List<Avaliacao> getAllByInfoLivro(InfoLivro infoLivro);

}
