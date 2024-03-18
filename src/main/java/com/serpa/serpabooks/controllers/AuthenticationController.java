package com.serpa.serpabooks.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serpa.serpabooks.infra.security.TokenService;
import com.serpa.serpabooks.models.dtos.AuthenticationDTO;
import com.serpa.serpabooks.models.dtos.CadastroDTO;
import com.serpa.serpabooks.models.dtos.LoginResponseDTO;
import com.serpa.serpabooks.models.dtos.ResetPasswordDTO;
import com.serpa.serpabooks.models.entities.Usuario;
import com.serpa.serpabooks.repositories.IUsuarioRepository;
import com.serpa.serpabooks.services.AuthenticationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;
	private final IUsuarioRepository usuarioRepository;
	private final TokenService tokenService;
	private final AuthenticationService authorizationService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO dto) {
		var userNamePassword = new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha());
		var auth = this.authenticationManager.authenticate(userNamePassword);

		var token = tokenService.generateToken((Usuario) auth.getPrincipal());

		return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDTO(token));
	}

	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastro(@RequestBody @Valid CadastroDTO dto) {
		if (this.usuarioRepository.findByLogin(dto.getLogin()) != null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já cadastrado no sistema");

		if(authorizationService.validateSenha(dto.getSenha())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\nSenha inválida!\nA Senha deve conter pelo menos: 8 caracteres, uma letra maiscula, uma letra miniscula e um número");
		}
		
		String senhaCriptografada = new BCryptPasswordEncoder().encode(dto.getSenha());

		Usuario usuario = new Usuario(dto.getLogin(), senhaCriptografada, dto.getNomeUsuario(), dto.getDataNascimento(), dto.getRole());

		this.usuarioRepository.save(usuario);

		return ResponseEntity.status(HttpStatus.OK).build();

	}

	@PostMapping("/reset-password")
	public ResponseEntity<?> ResetPassword(@RequestBody @Valid ResetPasswordDTO dto) {
		try {
			authorizationService.resetPassword(dto);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

}
