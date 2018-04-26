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

import com.rdgcardoso.baladas.api.model.Balada;
import com.rdgcardoso.baladas.api.repository.BaladaRepository;

@RestController
@RequestMapping("/baladas")
public class BaladaResource {

	@Autowired
	private BaladaRepository baladasRepository;

	@PostMapping
	public ResponseEntity<Balada> adicionar(@Valid @RequestBody Balada balada) {

		Balada baladaNova = new Balada();
		BeanUtils.copyProperties(balada, baladaNova, "id");
		baladaNova = baladasRepository.save(baladaNova);	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(baladaNova);
	}

	@GetMapping
	public List<Balada> listar() {
		return baladasRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Balada> buscar(@PathVariable Long id) {
		Optional<Balada> balada = baladasRepository.findById(id);

		if (!balada.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(balada.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Balada> atualizar(@PathVariable Long id, @Valid @RequestBody Balada balada) {

		Optional<Balada> baladaExistente = baladasRepository.findById(id);

		if (!baladaExistente.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Balada baladaLocalizada = baladaExistente.get();

		BeanUtils.copyProperties(balada, baladaLocalizada, "id");
		baladaLocalizada = baladasRepository.save(baladaLocalizada);
		return ResponseEntity.ok(baladaLocalizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {

		Optional<Balada> balada = baladasRepository.findById(id);

		if (!balada.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		baladasRepository.delete(balada.get());
		return ResponseEntity.noContent().build();
	}
}
