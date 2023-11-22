package com.cibertec.edu.springbootecommercedaw.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="accesories")
@Data
public class Accesories {
	
	@Id
	@Column(name = "id_accessories")
	private Long id_accessories;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "id",nullable = false)
	private Product product; 
	
	@ManyToOne
	@JoinColumn(name = "id_company",nullable = false)
	private Companies companies;
	
	@ManyToOne
	@JoinColumn(name = "category_id",nullable = false)
	private ProductCategory category;
	
	

}
