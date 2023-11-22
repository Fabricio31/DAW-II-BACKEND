package com.cibertec.edu.springbootecommercedaw.request;

import lombok.Data;

@Data
public class ConsoleRequest {
	
	private Long id_console;
	private String name_console;
	private String description;
	private String model;
	private String year;
	private Long id_product;
	//Se agrego id_category_product
	private Long id;

}
