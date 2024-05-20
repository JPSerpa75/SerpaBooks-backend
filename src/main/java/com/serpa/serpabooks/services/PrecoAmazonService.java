package com.serpa.serpabooks.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.serpa.serpabooks.models.dtos.PrecoAmazonDTO;
import com.serpa.serpabooks.models.entities.Livro;
import com.serpa.serpabooks.repositories.IPrecoAmazonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrecoAmazonService {

	private final IPrecoAmazonRepository precoAmazonRepository;
	private final ModelMapper mapper;

	public PrecoAmazonDTO getPrecoAmazonByIdLivro(Long idLivro) {
		var preco = precoAmazonRepository.findByLivro(new Livro(idLivro));
		return mapper.map(preco, PrecoAmazonDTO.class);
	}

}
