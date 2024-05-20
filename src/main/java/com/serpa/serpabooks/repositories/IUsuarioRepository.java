package com.serpa.serpabooks.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.serpa.serpabooks.models.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	public UserDetails findByEmail(String email);

	public Usuario findByEmailAndDataNascimento(String email, LocalDate dataNascimento);

}
