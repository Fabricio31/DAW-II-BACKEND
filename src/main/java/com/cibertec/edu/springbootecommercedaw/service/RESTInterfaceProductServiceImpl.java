package com.cibertec.edu.springbootecommercedaw.service;

import com.cibertec.edu.springbootecommercedaw.model.ProductosApi;
import com.cibertec.edu.springbootecommercedaw.repository.RESTProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RESTInterfaceProductServiceImpl implements RESTInterfaceProductService {

    @Autowired
    private RESTProductRepository restProductRepository;


    @Override
    public ProductosApi newProductosApi(ProductosApi newproductosApi) {
        return restProductRepository.save(newproductosApi);
    }

    @Override
    public Iterable<ProductosApi> getAll() {
        return this.restProductRepository.findAll();
    }

    @Override
    public ProductosApi modifyProduct(ProductosApi productosApi) {
        Optional<ProductosApi> productEncontrado = this.restProductRepository.findById(productosApi.getId_product());
        if(productEncontrado.get() != null){
            productEncontrado.get().setName(productosApi.getName());
            productEncontrado.get().setSku(productosApi.getSku());
            productEncontrado.get().setDescription(productosApi.getDescription());
            productEncontrado.get().setUnit_price(productosApi.getUnit_price());
            productEncontrado.get().setImage_url(productosApi.getImage_url());
            productEncontrado.get().setUnits_in_stock(productosApi.getUnits_in_stock());
            productEncontrado.get().setDate_created(productosApi.getDate_created());
            productEncontrado.get().setLast_updated(productosApi.getLast_updated());
            //productEncontrado.get().setName(productosApi.getName()); ???
            return this.newProductosApi(productEncontrado.get());
        }
        return null;
    }

    @Override
    public Boolean deleteProduct(Long id) {
        this.restProductRepository.deleteById(id);
        return true;
    }

}
