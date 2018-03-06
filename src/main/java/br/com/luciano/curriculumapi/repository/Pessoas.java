package br.com.luciano.curriculumapi.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luciano.curriculumapi.model.Pessoa;
import br.com.luciano.curriculumapi.repository.helper.pessoas.PessoasQueries;

@Repository
public interface Pessoas extends JpaRepository<Pessoa, Integer>, PessoasQueries {
	
	Optional<Pessoa> findById(Integer id);

}