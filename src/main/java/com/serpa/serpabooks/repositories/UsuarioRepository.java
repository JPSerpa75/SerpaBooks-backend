package com.serpa.serpabooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.serpa.serpabooks.models.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public UserDetails findByLogin(String login);

}
