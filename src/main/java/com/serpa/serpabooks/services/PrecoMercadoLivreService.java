package com.serpa.serpabooks.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.serpa.serpabooks.models.dtos.PrecoMercadoLivreDTO;
import com.serpa.serpabooks.models.entities.Livro;
import com.serpa.serpabooks.repositories.IPrecoMercadoLivreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrecoMercadoLivreService {

	private final IPrecoMercadoLivreRepository precoMercadoLivreRepository;
	private final ModelMapper mapper;

	public PrecoMercadoLivreDTO getPrecoMercadoLivreByIdLivro(Long idLivro) {
		var preco = precoMercadoLivreRepository.findByLivro(new Livro(idLivro));
		return mapper.map(preco, PrecoMercadoLivreDTO.class);
	}

}
