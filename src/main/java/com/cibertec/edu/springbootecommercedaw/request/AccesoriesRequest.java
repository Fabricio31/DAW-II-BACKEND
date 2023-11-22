package com.cibertec.edu.springbootecommercedaw.request;

import lombok.Data;

@Data
public class AccesoriesRequest {

	private Long id_accessories;
	private String name;
	private String description;
	private Long id_product;
	private Long id_company;
	//Se agrego
	private Long id;
}
