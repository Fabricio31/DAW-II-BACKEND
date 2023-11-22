package com.cibertec.edu.springbootecommercedaw.request;

import lombok.Data;

@Data
public class GamesRequest {
	
	
	private Long id_game;
	private String name;
	private String description;
	private Long id_console;
	private Long id_category;
	private Long id_platforms;
	private Long id_product;
	//Se agrego 
	private Long id;

}
