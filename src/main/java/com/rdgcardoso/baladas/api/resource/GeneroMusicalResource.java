package com.rdgcardoso.baladas.api.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.RestController;

import com.rdgcardoso.baladas.api.model.GeneroMusical;
import com.rdgcardoso.baladas.api.repository.GeneroMusicalRepository;

@RestController
@RequestMapping("/generosmusicais")
public class GeneroMusicalResource {

	@Autowired
	private GeneroMusicalRepository generoMusicalRepository;

	@PostMapping
	public ResponseEntity<GeneroMusical> adicionar(@Valid @RequestBody GeneroMusical generoMusical) {

		GeneroMusical generoMusicalNovo = new GeneroMusical();
		BeanUtils.copyProperties(generoMusical, generoMusicalNovo, "id");
		generoMusicalNovo = generoMusicalRepository.save(generoMusicalNovo);

		return ResponseEntity.status(HttpStatus.CREATED).body(generoMusicalNovo);
	}

	@GetMapping
	public List<GeneroMusical> listar() {
		return generoMusicalRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<GeneroMusical> buscar(@PathVariable Long id) {
		Optional<GeneroMusical> generoMusical = generoMusicalRepository.findById(id);

		if (!generoMusical.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(generoMusical.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<GeneroMusical> atualizar(@PathVariable Long id,
			@Valid @RequestBody GeneroMusical generoMusical) {

		Optional<GeneroMusical> generoMusicalExistente = generoMusicalRepository.findById(id);

		if (!generoMusicalExistente.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		GeneroMusical generoMusicalLocalizada = generoMusicalExistente.get();

		BeanUtils.copyProperties(generoMusical, generoMusicalLocalizada, "id");
		generoMusicalLocalizada = generoMusicalRepository.save(generoMusicalLocalizada);
		return ResponseEntity.ok(generoMusicalLocalizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {

		Optional<GeneroMusical> generoMusical = generoMusicalRepository.findById(id);

		if (!generoMusical.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		generoMusicalRepository.delete(generoMusical.get());
		return ResponseEntity.noContent().build();
	}
}
