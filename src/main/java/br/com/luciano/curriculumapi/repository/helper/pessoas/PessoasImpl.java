package br.com.luciano.curriculumapi.repository.helper.pessoas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.com.luciano.curriculumapi.model.Pessoa;
import br.com.luciano.curriculumapi.repository.filter.PessoaFilter;

public class PessoasImpl implements PessoasQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Pessoa> filtrar(PessoaFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteria = builder.createQuery(Pessoa.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Pessoa> query = manager.createQuery(criteria);

		
		return query.getResultList();
	}
	
	private Predicate[] criarRestricoes(PessoaFilter pessoaFilter, CriteriaBuilder builder, Root<Pessoa> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(pessoaFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get("nome")), "%" + pessoaFilter.getNome().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(pessoaFilter.getExperienciaProfissional())) {
			predicates.add(builder.like(
							builder.lower(root.get("experienciaProfissional")), "%" + pessoaFilter.getExperienciaProfissional().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(pessoaFilter.getQualificacoes())) {
			predicates.add(builder.like(
					builder.lower(root.get("qualificacoes")), "%" + pessoaFilter.getQualificacoes().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(pessoaFilter.getIdiomas())) {
			predicates.add(builder.like(
					builder.lower(root.get("idiomas")), "%" + pessoaFilter.getIdiomas().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
