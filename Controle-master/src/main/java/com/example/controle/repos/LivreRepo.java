package com.example.controle.repos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.controle.entities.Livre;

public interface LivreRepo extends JpaRepository<Livre, Long>{
	

}
