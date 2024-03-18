package com.serpa.serpabooks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serpa.serpabooks.models.entities.Livro;

@Repository
public interface ILivroRepository extends JpaRepository<Livro, Long> {

	@Query("Select l from Livro l where l.infoLivro.id = ?1")
	public List<Livro> findByInfoLivroById(Long idInfoLivro) throws Exception;

}
