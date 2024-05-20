package com.serpa.serpabooks.repositories.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.serpa.serpabooks.models.dtos.FilterDTO;
import com.serpa.serpabooks.models.dtos.InfoLivroGridDTO;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class InfoLivroRepositoryImpl {

	private final EntityManager entityManager;

	public Page<InfoLivroGridDTO> search(FilterDTO dto, Pageable pageable) throws Exception {
		var hql = new StringBuilder();

		montarSelectGrid(hql);
		montarQueryAndFilters(hql, dto);

		var query = entityManager.createQuery(hql.toString(), InfoLivroGridDTO.class);
		if (dto != null && dto.getTextoChave() != null && !dto.getTextoChave().isBlank()) {
			query.setParameter("textoChave", dto.getTextoChave().toLowerCase());
		}

		if (dto.getIdsAutores() != null && !dto.getIdsAutores().isEmpty()) {
			query.setParameter("idsAutores", dto.getIdsAutores());
		}

		if (dto.getIdsEditoras() != null && !dto.getIdsEditoras().isEmpty()) {
			query.setParameter("idsEditoras", dto.getIdsEditoras());
		}

		query.setFirstResult((int) pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		var result = query.getResultList();

		return new PageImpl<>(result, pageable, countTotalResults(dto));
	}

	public Long countTotalResults(FilterDTO dto) throws Exception {

		var hql = new StringBuilder();
		hql.append(" select count(il.id) ");
		montarQueryAndFilters(hql, dto);

		var query = entityManager.createQuery(hql.toString(), Long.class);
		if (dto != null && dto.getTextoChave() != null && !dto.getTextoChave().isBlank()) {
			query.setParameter("textoChave", dto.getTextoChave().toLowerCase());
		}
		if (dto.getIdsAutores() != null && !dto.getIdsAutores().isEmpty()) {
			query.setParameter("idsAutores", dto.getIdsAutores());
		}

		if (dto.getIdsEditoras() != null && !dto.getIdsEditoras().isEmpty()) {
			query.setParameter("idsEditoras", dto.getIdsEditoras());
		}

		return query.getSingleResult();
	}

	private void montarSelectGrid(StringBuilder hql) {
		hql.append(" SELECT distinct new com.serpa.serpabooks.models.dtos.InfoLivroGridDTO( ");
		hql.append("    il.id as idInfoLivro, ");
		hql.append("	il.titulo as tituloLivro, ");
		hql.append("	il.notaLivro as notaLivro, ");
		hql.append("	il.idioma as idioma, ");
		hql.append("	il.resumo as resumo, ");
		hql.append("	il.sinopse as sinopse, ");
		hql.append("	c.descricaoCapa as descricaoCapa, ");
		hql.append("	e.nomeEditora as nomeEditora, ");
		hql.append("	l.urlImagem as urlImagem, ");
		hql.append("	l.dataPublicacao as dataPublicacao, ");
		hql.append("	a.nomeAutor as nomeAutor ");
		hql.append(" ) ");
	}

	private void montarQueryAndFilters(StringBuilder hql, FilterDTO dto) {
		hql.append(" FROM InfoLivro il ");
		hql.append(" JOIN Livro l on il.id = l.infoLivro.id ");
		hql.append(" JOIN Editora e on e.id = l.editora.id ");
		hql.append(" JOIN Capa c on c.id = l.capa.id ");
		hql.append(" JOIN Autor a on a.id = il.autor.id ");
		hql.append(" WHERE 1=1 ");

		if (dto != null && dto.getTextoChave() != null && !dto.getTextoChave().isBlank()) {
			hql.append("	AND ( lower(il.titulo) like CONCAT('%', :textoChave, '%') ");
			hql.append(" 	OR cast(il.notaLivro as char) like CONCAT('%', :textoChave, '%') ");
			hql.append(" 	OR lower(il.idioma) like CONCAT('%', :textoChave, '%') ");
			hql.append("	OR lower(il.resumo) like CONCAT('%', :textoChave, '%') ");
			hql.append("	OR lower(c.descricaoCapa) like CONCAT('%', :textoChave, '%') ");
			hql.append("	OR lower(e.nomeEditora) like CONCAT('%', :textoChave, '%') ");
			hql.append("	OR lower(a.nomeAutor) like CONCAT('%', :textoChave, '%') )");
		}

		if (dto.getIdsAutores() != null && !dto.getIdsAutores().isEmpty()) {
			hql.append("	AND a.id in :idsAutores ");
		}

		if (dto.getIdsEditoras() != null && !dto.getIdsEditoras().isEmpty()) {
			hql.append("	AND e.id in :idsEditoras ");
		}

		hql.append(" ORDER BY il.notaLivro DESC ");

	}

}
