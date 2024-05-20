package com.serpa.serpabooks.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serpa.serpabooks.services.PrecoAmazonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("preco-amazon")
@CrossOrigin
@RequiredArgsConstructor
public class PrecoAmazonController {

	private final PrecoAmazonService precoAmazonService;

	@GetMapping("by-id-livro/{id}")
	public ResponseEntity<?> getPrecosByIdLivro(@PathVariable(value = "id") Long idLivro) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(precoAmazonService.getPrecoAmazonByIdLivro(idLivro));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
