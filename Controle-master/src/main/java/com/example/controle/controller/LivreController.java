package com.example.controle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.controle.entities.Livre;
import com.example.controle.service.LivreService;

@RestController
@RequestMapping("/emsi_api")
public class LivreController {
	
	@Autowired
	private LivreService service;
	
	@PostMapping("/add")
	public Livre addLivre(@RequestBody Livre livre) {
		return service.saveLivre(livre);
	}
	
	@GetMapping("/livres")
	public List<Livre> findAllLivres(){
		return service.getAllLivres();
	}
	
	@GetMapping("/livres/{id}")
	public Livre findLivreById(@PathVariable int id){
		return service.getLivreById(id);
	}
	
	@PutMapping("/update/{id}")
	public Livre updateLivre(@PathVariable int id, @RequestBody Livre livre) {
		return service.updateLivre(id,livre);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteLivre(@PathVariable int id) {
		return service.deleteLivre(id);
	}
	

}
