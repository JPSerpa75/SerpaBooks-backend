package com.serpa.serpabooks.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serpa.serpabooks.services.PrecoMercadoLivreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("preco-mercado-livre")
@CrossOrigin
@RequiredArgsConstructor
public class PrecoMercadoLivreController {

	private final PrecoMercadoLivreService precoMercadoLivreService;

	@GetMapping("by-id-livro/{id}")
	public ResponseEntity<?> getPrecosByIdLivro(@PathVariable(value = "id") Long idLivro) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(precoMercadoLivreService.getPrecoMercadoLivreByIdLivro(idLivro));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
