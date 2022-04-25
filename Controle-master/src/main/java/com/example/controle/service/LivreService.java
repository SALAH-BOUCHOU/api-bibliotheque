package com.example.controle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.example.controle.entities.Livre;
import com.example.controle.repos.LivreRepo;

@Service
public class LivreService {
	
	@Autowired
	private LivreRepo repos;
	
	public Livre saveLivre(Livre livre) {
		return repos.save(livre);		
	}
	
	public List<Livre> getAllLivres(){
		return repos.findAll(Sort.by(Order.asc("titre")));
	}

	public Livre getLivreById(int id){
		Optional<Livre> livre = repos.findById(id);
		if(livre.isPresent()){
			return livre.get();
		}
		throw new RuntimeException("Livre not found");
	}
	
	public String deleteLivre(int id) {
		Optional<Livre> livre = repos.findById(id);
		if(livre.isPresent()){
			repos.deleteById(id);
			return "Livre supprimé "+ id;
		}
		throw new RuntimeException("Livre not found");
	}
	
	
	
	public void updateLivre(int id, Livre livre) {
		Livre OldLivre = repos.findById(livre.getId()).orElse(null);
		OldLivre.setTitre(livre.getTitre());
		OldLivre.setDateSortie(livre.getDateSortie());
		OldLivre.setAuteur(livre.getAuteur());
		OldLivre.setNbrPage(livre.getNbrPage());
		OldLivre.setDateConsult(livre.getDateConsult());
		OldLivre.setDispo(livre.isDispo());
		saveLivre(OldLivre);
	}
	
	
	
	

}
