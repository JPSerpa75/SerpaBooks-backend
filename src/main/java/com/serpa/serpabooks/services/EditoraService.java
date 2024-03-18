package com.serpa.serpabooks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.serpa.serpabooks.models.dtos.EditoraDTO;
import com.serpa.serpabooks.models.entities.Editora;
import com.serpa.serpabooks.repositories.IEditoraRepository;
import com.serpa.serpabooks.utils.Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditoraService {

	private final IEditoraRepository editoraRepository;

	private final ModelMapper modelMapper;

	public EditoraDTO save(EditoraDTO dto) throws Exception {
		validated(dto);
		Editora editora = modelMapper.map(dto, Editora.class);
		return modelMapper.map(editoraRepository.save(editora), EditoraDTO.class);

	}

	public List<EditoraDTO> getAll() throws Exception {
		return Utils.mapList(editoraRepository.findAll(), EditoraDTO.class, modelMapper);
	}

	public EditoraDTO getById(Long id) throws Exception {
		Optional<Editora> editoraOptional = editoraRepository.findById(id);

		if (editoraOptional.isEmpty()) {
			throw new Exception("Editora não encontrada");
		}

		return modelMapper.map(editoraOptional, EditoraDTO.class);
	}

	public EditoraDTO update(Long id, EditoraDTO dto) throws Exception {
		Optional<Editora> editoraOptional = editoraRepository.findById(id);

		if (editoraOptional.isEmpty()) {
			throw new Exception("Editora não encontrada");
		}

		dto.setId(id);
		return save(dto);
	}

	public String delete(Long id) throws Exception {
		Optional<Editora> editoraOptional = editoraRepository.findById(id);

		if (editoraOptional.isEmpty()) {
			throw new Exception("Editora não encontrada");
		}

		editoraRepository.delete(editoraOptional.get());
		return "Editora deletada com sucesso!";

	}

	private void validated(EditoraDTO dto) throws Exception {
		List<String> errors = new ArrayList<>();

		if (dto.getNomeEditora() == null) {
			errors.add("Nome da editora não pode ser vazio!");
		}

		if (!errors.isEmpty()) {
			throw new Exception(errors.toString());
		}

	}
}
