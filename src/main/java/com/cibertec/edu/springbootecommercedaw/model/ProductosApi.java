package com.cibertec.edu.springbootecommercedaw.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="productosapi")
@Getter
@Setter
public class ProductosApi {

    @Id
    @Column(name = "id")
    private Long id_product;

    @Column(name="name")
    private String name;

    @Column(name="sku")
    private String sku;

    @Column(name="description")
    private String description;

    @Column(name="unit_price")
    private BigDecimal unit_price;

    @Column(name="image_url")
    private String image_url;

    @Column(name="units_in_stock")
    private Integer units_in_stock;

    @Column(name="date_created")
    private String date_created;

    @Column(name="last_updated")
    private String last_updated;

}
