package com.serpa.serpabooks.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.serpa.serpabooks.models.dtos.ResetPasswordDTO;
import com.serpa.serpabooks.repositories.IUsuarioRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

	private final IUsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepository.findByEmail(username);
	}

	public void resetPassword(@Valid ResetPasswordDTO dto) throws Exception {
		var usuario = usuarioRepository.findByEmailAndDataNascimento(dto.getEmailUsuario(), dto.getDataNascimentoUsuario());

		if (usuario == null || (!usuario.getNomeUsuario().equals(dto.getNomeUsuario()))) {
			throw new Exception("Não foi encontrado usuário com essas informações!");
		}

		if(validateSenha(dto.getNovaSenha())) {
			throw new Exception("\nSenha inválida!\nA nova senha deve conter pelo menos: 8 caracteres, uma letra maiscula, uma letra miniscula e um número");
		}
		
		String senhaCriptografada = new BCryptPasswordEncoder().encode(dto.getNovaSenha());
		usuario.setSenha(senhaCriptografada);

		usuarioRepository.save(usuario);

	}
	
	public boolean validateSenha(String senha) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
		return !senha.matches(regex);
	}

}
