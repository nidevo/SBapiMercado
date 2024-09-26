package com.api.mercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.mercado.model.Produto;
import com.api.mercado.repository.MercadoRepository;



@RestController
@RequestMapping("/mercado")
public class MercadoController {
	
	@Autowired
	private MercadoRepository repository;
	
	@GetMapping
	public List<Produto> listar(){
		return repository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Produto listarid(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com o ID: " + id));
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Produto produto) {
		repository.save(produto);
		
	}
	
	@PutMapping("/{id}")
	public void atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		
	    repository.findById(id)
	        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com o ID: " + id));

	    
	    produto.setId(id);
	    repository.save(produto);
		
	}
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		Produto produto = repository.findById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado para exclusão com o ID: " + id));
		
		repository.delete(produto);
	}
	
	
	
}