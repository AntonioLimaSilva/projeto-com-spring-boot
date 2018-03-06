package br.com.luciano.curriculumapi.repository.helper.pessoas;

import java.util.List;

import br.com.luciano.curriculumapi.model.Pessoa;
import br.com.luciano.curriculumapi.repository.filter.PessoaFilter;

public interface PessoasQueries {
	
	List<Pessoa> filtrar(PessoaFilter filtro);

}
