package com.serpa.serpabooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serpa.serpabooks.models.entities.Livro;
import com.serpa.serpabooks.models.entities.PrecoMercadoLivre;

public interface IPrecoMercadoLivreRepository extends JpaRepository<PrecoMercadoLivre, Long> {

	public PrecoMercadoLivre findByLivro(Livro livro);

}
