package com.serpa.serpabooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serpa.serpabooks.models.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
