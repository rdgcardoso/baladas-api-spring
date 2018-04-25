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
	private GeneroMusicalRepository GeneroMusicalRepository;

	@PostMapping
	public ResponseEntity<GeneroMusical> adicionar(@Valid @RequestBody GeneroMusical GeneroMusical) {

		GeneroMusical GeneroMusicalNovo = GeneroMusicalRepository.save(GeneroMusical);

		return ResponseEntity.status(HttpStatus.CREATED).body(GeneroMusicalNovo);
	}

	@GetMapping
	public List<GeneroMusical> listar() {
		return GeneroMusicalRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<GeneroMusical> buscar(@PathVariable Long id) {
		Optional<GeneroMusical> GeneroMusical = GeneroMusicalRepository.findById(id);

		if (!GeneroMusical.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(GeneroMusical.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<GeneroMusical> atualizar(@PathVariable Long id, @Valid @RequestBody GeneroMusical GeneroMusical) {

		Optional<GeneroMusical> GeneroMusicalExistente = GeneroMusicalRepository.findById(id);

		if (!GeneroMusicalExistente.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		GeneroMusical GeneroMusicalLocalizada = GeneroMusicalExistente.get();

		BeanUtils.copyProperties(GeneroMusical, GeneroMusicalLocalizada, "id");
		GeneroMusicalLocalizada = GeneroMusicalRepository.save(GeneroMusicalLocalizada);
		return ResponseEntity.ok(GeneroMusicalLocalizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {

		Optional<GeneroMusical> GeneroMusical = GeneroMusicalRepository.findById(id);

		if (!GeneroMusical.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		GeneroMusicalRepository.delete(GeneroMusical.get());
		return ResponseEntity.noContent().build();
	}
}
