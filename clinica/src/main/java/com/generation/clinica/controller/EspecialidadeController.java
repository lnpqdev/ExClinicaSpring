package com.generation.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.clinica.model.EspecialidadeModel;
import com.generation.clinica.repository.EspecialidadeRepository;

@RestController
@RequestMapping("/especialidade")
@CrossOrigin("*")
public class EspecialidadeController {
	
	@Autowired
	private EspecialidadeRepository repository;
	
	//get
	//pegando a especialidade pelo código
	@GetMapping("/{codEspecialidade}")
	public ResponseEntity<EspecialidadeModel>
	GetById(@PathVariable long codEspecialidade){
		return repository.findById(codEspecialidade).map(resp->ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());}
	
	@GetMapping
	public ResponseEntity<List<EspecialidadeModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll()); }
	
	@GetMapping("/especialidade/{nomeEspecialidade}")
	public ResponseEntity<List<EspecialidadeModel>>
	getByNome(@PathVariable String nomeEspecialidade) {
		return ResponseEntity.ok(repository.findAllBynomeEspecialidadeContainingIgnoreCase(nomeEspecialidade));
	
	
	}
	
	//post
	@PostMapping
	public ResponseEntity <EspecialidadeModel> Post
	(@RequestBody EspecialidadeModel especialidade) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(especialidade));
	}
	
	
	//put
	
	@PostMapping
	public ResponseEntity <EspecialidadeModel> Put
	(@RequestBody EspecialidadeModel especialidade) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(especialidade));
	}
	
	//delete
	@DeleteMapping("/{codEspecialidade}")
	public void delete(@PathVariable long codEspecialidade)
	{
		repository.deleteById(codEspecialidade);
	}
	

}
