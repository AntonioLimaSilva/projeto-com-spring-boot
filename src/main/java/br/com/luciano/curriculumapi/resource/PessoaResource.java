package br.com.luciano.curriculumapi.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.luciano.curriculumapi.model.Pessoa;
import br.com.luciano.curriculumapi.repository.Pessoas;
import br.com.luciano.curriculumapi.repository.filter.PessoaFilter;
import br.com.luciano.curriculumapi.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private Pessoas pessoas;
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> buscarTodas() {
		return this.pessoas.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Integer id) { 	
		Optional<Pessoa> pessoaOptional = this.pessoas.findById(id);
		
		if(pessoaOptional.isPresent()) {
			return ResponseEntity.ok(pessoaOptional.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/filtro")
	public List<Pessoa> filtrar(PessoaFilter filtro) { 			
		return this.pessoas.filtrar(filtro);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> inserir(@Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = this.pessoas.save(pessoa);

		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(pessoaSalva.getId()).toUri()).body(pessoaSalva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> editar(@PathVariable Integer id, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.editar(id, pessoa);
		return ResponseEntity.ok(pessoaSalva);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Integer id) {
		this.pessoas.delete(id);
	}

}
