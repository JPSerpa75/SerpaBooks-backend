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

import com.serpa.serpabooks.models.dtos.FilterDTO;
import com.serpa.serpabooks.models.dtos.InfoLivroUpdateDTO;
import com.serpa.serpabooks.services.InfoLivroService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("info-livro")
@CrossOrigin
@RequiredArgsConstructor
public class InfoLivroController {

	private final InfoLivroService infoLivroService;

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(infoLivroService.getById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/search")
	public ResponseEntity<?> search(@RequestBody @Valid FilterDTO filter) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(infoLivroService.search(filter));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("update-resumo-sinopse")
	public ResponseEntity<?> updateResumoSinopse(@RequestBody InfoLivroUpdateDTO dto) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(infoLivroService.updateResumoSinopse(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
