package com.serpa.serpabooks.services;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.serpa.serpabooks.models.dtos.AvaliacaoDTO;
import com.serpa.serpabooks.models.entities.Avaliacao;
import com.serpa.serpabooks.models.entities.InfoLivro;
import com.serpa.serpabooks.repositories.IAvaliacaoRepository;
import com.serpa.serpabooks.utils.Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {

	private final IAvaliacaoRepository avaliacaoRepository;
	private final InfoLivroService infoLivroService;
	private final ModelMapper mapper;

	public List<AvaliacaoDTO> getAllByIdInfoLivro(Long idInfoLivro) throws Exception {
		var infoLivro = new InfoLivro();
		infoLivro.setId(idInfoLivro);
		return Utils.mapList(avaliacaoRepository.getAllByInfoLivro(infoLivro), AvaliacaoDTO.class, mapper);
	}

	public AvaliacaoDTO insert(AvaliacaoDTO dto) throws Exception {

		var infoLivro = infoLivroService.getById(dto.getIdInfoLivro());
		Float novaNota = null;
		if (infoLivro.getNotaLivro() != null) {
			novaNota = (((infoLivro.getNotaLivro() * 10) + (dto.getValorAvaliacao() * 1)) / (10 + 1));
		} else {
			novaNota = dto.getValorAvaliacao();
		}

		infoLivro.setNotaLivro(Float.valueOf(String.format("%.2f", novaNota).replace(",", ".")));
		infoLivroService.save(infoLivro);

		var avaliacao = mapper.map(dto, Avaliacao.class);
		avaliacao.setDataAvaliacao(LocalDateTime.now());

		return mapper.map(avaliacaoRepository.save(avaliacao), AvaliacaoDTO.class);
	}

}
