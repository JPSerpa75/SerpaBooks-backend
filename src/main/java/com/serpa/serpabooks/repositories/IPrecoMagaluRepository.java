package com.serpa.serpabooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serpa.serpabooks.models.entities.Livro;
import com.serpa.serpabooks.models.entities.PrecoMagalu;

public interface IPrecoMagaluRepository extends JpaRepository<PrecoMagalu, Long> {

	public PrecoMagalu findByLivro(Livro livro);

}
