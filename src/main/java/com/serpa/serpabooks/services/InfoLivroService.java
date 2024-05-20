package com.serpa.serpabooks.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.serpa.serpabooks.models.dtos.FilterDTO;
import com.serpa.serpabooks.models.dtos.InfoLivroDTO;
import com.serpa.serpabooks.models.dtos.InfoLivroGridDTO;
import com.serpa.serpabooks.models.dtos.InfoLivroUpdateDTO;
import com.serpa.serpabooks.models.entities.InfoLivro;
import com.serpa.serpabooks.repositories.IInfoLivroRepository;
import com.serpa.serpabooks.repositories.impl.InfoLivroRepositoryImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InfoLivroService {

	private final IInfoLivroRepository repository;
	private final InfoLivroRepositoryImpl customRepository;
	private final ModelMapper modelMapper;

	public Page<InfoLivroGridDTO> search(@Valid FilterDTO filter) throws Exception {
		if (filter.getPageNumber() == null || filter.getPageSize() == null) {
			throw new Exception("Informe o qual pagina e o tamanho dela");
		}

		return customRepository.search(filter, PageRequest.of(filter.getPageNumber(), filter.getPageSize()));
	}

	public InfoLivroDTO getById(Long id) throws Exception {
		Optional<InfoLivro> livroOptional = repository.findById(id);

		if (livroOptional.isEmpty()) {
			throw new Exception("Livro não encontrado");
		}

		return modelMapper.map(livroOptional, InfoLivroDTO.class);

	}

	public InfoLivroDTO save(InfoLivroDTO dto) {
		var infoLivro = modelMapper.map(dto, InfoLivro.class);
		return modelMapper.map(repository.save(infoLivro), InfoLivroDTO.class);
	}

	public InfoLivroDTO updateResumoSinopse(InfoLivroUpdateDTO dto) throws Exception {
		var infoLivro = repository.findById(dto.getId());

		if (infoLivro == null) {
			throw new Exception("Livro não encontrado ");
		}

		infoLivro.get().setResumo(dto.getResumo());
		infoLivro.get().setSinopse(dto.getSinopse());

		return modelMapper.map(repository.save(infoLivro.get()), InfoLivroDTO.class);
	}

}
