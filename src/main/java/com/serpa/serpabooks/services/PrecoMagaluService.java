package com.serpa.serpabooks.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.serpa.serpabooks.models.dtos.PrecoMagaluDTO;
import com.serpa.serpabooks.models.entities.Livro;
import com.serpa.serpabooks.repositories.IPrecoMagaluRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrecoMagaluService {

	private final IPrecoMagaluRepository precoMagaluRepository;
	private final ModelMapper mapper;

	public PrecoMagaluDTO getPrecoMagaluByIdLivro(Long idLivro) {
		var preco = precoMagaluRepository.findByLivro(new Livro(idLivro));
		return mapper.map(preco, PrecoMagaluDTO.class);
	}

}
