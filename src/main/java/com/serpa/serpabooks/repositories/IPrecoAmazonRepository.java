package com.serpa.serpabooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serpa.serpabooks.models.entities.Livro;
import com.serpa.serpabooks.models.entities.PrecoAmazon;

public interface IPrecoAmazonRepository extends JpaRepository<PrecoAmazon, Long> {

	public PrecoAmazon findByLivro(Livro livro);

}
