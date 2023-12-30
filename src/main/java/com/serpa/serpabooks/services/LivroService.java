package com.serpa.serpabooks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serpa.serpabooks.models.dtos.LivroDTO;
import com.serpa.serpabooks.models.entities.Livro;
import com.serpa.serpabooks.repositories.LivroRepository;
import com.serpa.serpabooks.utils.Utils;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private ModelMapper modelMapper;

	public LivroDTO save(LivroDTO dto) throws Exception {
		validated(dto);
		Livro livro = modelMapper.map(dto, Livro.class);
		return modelMapper.map(livroRepository.save(livro), LivroDTO.class);

	}

	public List<LivroDTO> getAll() throws Exception {
		return Utils.mapList(livroRepository.findAll(), LivroDTO.class, modelMapper);
	}

	public LivroDTO getById(Long id) throws Exception {
		Optional<Livro> livroOptional = livroRepository.findById(id);

		if (livroOptional.isEmpty()) {
			throw new Exception("Livro não encontrado");
		}

		return modelMapper.map(livroOptional, LivroDTO.class);
	}

	public LivroDTO update(Long id, LivroDTO dto) throws Exception {
		Optional<Livro> livroOptional = livroRepository.findById(id);

		if (livroOptional.isEmpty()) {
			throw new Exception("Livro não encontrado");
		}

		dto.setId(id);
		return save(dto);
	}

	public String delete(Long id) throws Exception {
		Optional<Livro> livroOptional = livroRepository.findById(id);

		if (livroOptional.isEmpty()) {
			throw new Exception("Livro não encontrado");
		}

		livroRepository.delete(livroOptional.get());
		return "Livro deletado com sucesso!";

	}

	private void validated(LivroDTO dto) throws Exception {
		List<String> errors = new ArrayList<>();
		
		if (dto.getAutor() == null || dto.getAutor().getId() == null) {
			errors.add("Autor não pode ser vazio!");
		}
		if (dto.getEditora() == null || dto.getEditora().getId() == null) {
			errors.add("Editora não pode ser vazia!");
		}
		if (dto.getCapa() == null || dto.getCapa().getId() == null) {
			errors.add("Capa não pode ser vazia!");
		}
		if (dto.getIsbn10() == null) {
			errors.add("ISBN-10 não pode ser vazio!");
		}
		if (dto.getIsbn13() == null) {
			errors.add("ISBN-13 não pode ser vazio!");
		}
		if (dto.getTitulo() == null) {
			errors.add("Título não pode ser vazio!");
		}
		if (dto.getDataPublicacao() == null) {
			errors.add("Data de publicação não pode ser vazia!");
		}
		if (dto.getDataPublicacao() == null) {
			errors.add("Data de cadastro não pode ser vazia!");
		}
		if (dto.getIsbn10() == null) {
			errors.add("ISBN 10 não pode ser vazio!");
		}
		
		if(!errors.isEmpty()) {
			throw new Exception(errors.toString());
		}

	}

}
