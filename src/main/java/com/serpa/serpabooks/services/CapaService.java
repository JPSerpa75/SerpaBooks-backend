package com.serpa.serpabooks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.serpa.serpabooks.models.dtos.CapaDTO;
import com.serpa.serpabooks.models.entities.Capa;
import com.serpa.serpabooks.repositories.ICapaRepository;
import com.serpa.serpabooks.utils.Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CapaService {

	private final ICapaRepository capaRepository;

	private final ModelMapper modelMapper;

	public CapaDTO save(CapaDTO dto) throws Exception {
		validated(dto);
		Capa Capa = modelMapper.map(dto, Capa.class);
		return modelMapper.map(capaRepository.save(Capa), CapaDTO.class);

	}

	public List<CapaDTO> getAll() throws Exception {
		return Utils.mapList(capaRepository.findAll(), CapaDTO.class, modelMapper);
	}

	public CapaDTO getById(Long id) throws Exception {
		Optional<Capa> CapaOptional = capaRepository.findById(id);

		if (CapaOptional.isEmpty()) {
			throw new Exception("Capa não encontrada");
		}

		return modelMapper.map(CapaOptional, CapaDTO.class);
	}

	public CapaDTO update(Long id, CapaDTO dto) throws Exception {
		Optional<Capa> CapaOptional = capaRepository.findById(id);

		if (CapaOptional.isEmpty()) {
			throw new Exception("Capa não encontrada");
		}

		dto.setId(id);
		return save(dto);
	}

	public String delete(Long id) throws Exception {
		Optional<Capa> CapaOptional = capaRepository.findById(id);

		if (CapaOptional.isEmpty()) {
			throw new Exception("Capa não encontrada");
		}

		capaRepository.delete(CapaOptional.get());
		return "Capa deletada com sucesso!";

	}

	private void validated(CapaDTO dto) throws Exception {
		List<String> errors = new ArrayList<>();

		if (dto.getDescricaoCapa() == null) {
			errors.add("Descrição da capa não pode ser vazia!");
		}

		if (!errors.isEmpty()) {
			throw new Exception(errors.toString());
		}

	}

}
