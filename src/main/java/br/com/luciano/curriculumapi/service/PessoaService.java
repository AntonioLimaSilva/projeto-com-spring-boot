package br.com.luciano.curriculumapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.luciano.curriculumapi.model.Pessoa;
import br.com.luciano.curriculumapi.repository.Pessoas;

@Service
public class PessoaService {
	
	@Autowired
	private Pessoas pessoas;

	public Pessoa editar(Integer id, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPeloId(id);
		
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return pessoas.save(pessoaSalva);
	}
	
	public Pessoa buscarPessoaPeloId(Integer id) {
		Pessoa pessoaSalva = pessoas.findOne(id);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return pessoaSalva;
	}

}
