package com.serpa.serpabooks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serpa.serpabooks.models.dtos.AutorDTO;
import com.serpa.serpabooks.models.entities.Autor;
import com.serpa.serpabooks.repositories.AutorRepository;
import com.serpa.serpabooks.utils.Utils;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private ModelMapper modelMapper;

	public AutorDTO save(AutorDTO dto) throws Exception {
		validated(dto);
		Autor autor = modelMapper.map(dto, Autor.class);
		return modelMapper.map(autorRepository.save(autor), AutorDTO.class);

	}

	public List<AutorDTO> getAll() throws Exception {
		return Utils.mapList(autorRepository.findAll(), AutorDTO.class, modelMapper);
	}

	public AutorDTO getById(Long id) throws Exception {
		Optional<Autor> autorOptional = autorRepository.findById(id);

		if (autorOptional.isEmpty()) {
			throw new Exception("Autor não encontrado");
		}

		return modelMapper.map(autorOptional, AutorDTO.class);
	}

	public AutorDTO update(Long id, AutorDTO dto) throws Exception {
		Optional<Autor> autorOptional = autorRepository.findById(id);

		if (autorOptional.isEmpty()) {
			throw new Exception("Autor não encontrado");
		}

		dto.setId(id);
		return save(dto);
	}

	public String delete(Long id) throws Exception {
		Optional<Autor> autorOptional = autorRepository.findById(id);

		if (autorOptional.isEmpty()) {
			throw new Exception("Autor não encontrado");
		}

		autorRepository.delete(autorOptional.get());
		return "Autor deletado com sucesso!";

	}

	private void validated(AutorDTO dto) throws Exception {
		List<String> errors = new ArrayList<>();

		if (dto.getNomeAutor() == null) {
			errors.add("Nome do autor não pode ser vazio!");
		}

		if (!errors.isEmpty()) {
			throw new Exception(errors.toString());
		}

	}

}
