package com.serpa.serpabooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serpa.serpabooks.models.dtos.LivroDTO;
import com.serpa.serpabooks.services.LivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid LivroDTO dto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno! " + e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(livroService.getAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno! " + e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(livroService.getById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno! " + e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody @Valid LivroDTO dto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(livroService.update(id, dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno! " + e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(livroService.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno! " + e.getMessage());
		}
	}
	
	@PostMapping("/avaliar")
	public ResponseEntity<?> avaliarLivro(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body("Vou usar aqui pra avaliar");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno! " + e.getMessage());
		}
	}

}
