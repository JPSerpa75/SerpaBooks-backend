package com.serpa.serpabooks.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serpa.serpabooks.models.dtos.AvaliacaoDTO;
import com.serpa.serpabooks.services.AvaliacaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("avaliacao")
@CrossOrigin
@RequiredArgsConstructor
public class AvaliacaoController {

	private final AvaliacaoService avaliacaoService;

	@GetMapping("by-id-info-livro/{id}")
	public ResponseEntity<?> getAllByIdInfoLivro(@PathVariable(value = "id") Long idInfoLivro) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.getAllByIdInfoLivro(idInfoLivro));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody AvaliacaoDTO dto) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.insert(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
