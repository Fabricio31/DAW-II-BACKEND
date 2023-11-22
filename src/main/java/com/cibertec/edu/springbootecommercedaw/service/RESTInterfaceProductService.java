package com.cibertec.edu.springbootecommercedaw.service;

import com.cibertec.edu.springbootecommercedaw.model.ProductosApi;
import org.springframework.stereotype.Service;


@Service
public interface RESTInterfaceProductService {

    ProductosApi newProductosApi(ProductosApi newproductosApi);
    Iterable<ProductosApi> getAll();
    ProductosApi modifyProduct(ProductosApi productosApi);
    Boolean deleteProduct(Long id);


}
