 package com.cibertec.edu.springbootecommercedaw.request;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ProductRequest {
	
	private Long id_product;
	private String name;
	private String sku;
	private String description;
	private BigDecimal unit_price;
	private String image_url;
	private Integer units_in_stock;
	private Date date_created;
	private Date last_updated;
	//Se agrego
	private Long id;

}
