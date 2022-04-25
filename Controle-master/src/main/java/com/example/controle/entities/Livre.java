package com.example.controle.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @AllArgsConstructor @NoArgsConstructor
public class Livre {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable=false)
	private String titre;
	
	@NonNull
	@Column(updatable=false, nullable=false)
	private String maisonEdit;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateSortie;
	
	@Column(nullable=false)
	private String auteur;
	
	@Column(nullable=false)
	private int nbrPage;
	
	@Column(unique=true, updatable=false, nullable=false)
	private String ISBN;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateConsult;
	
	@NonNull
	@Column(nullable=false)
	private boolean dispo;
}
