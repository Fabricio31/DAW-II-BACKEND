package com.cibertec.edu.springbootecommercedaw.service;

import com.cibertec.edu.springbootecommercedaw.model.ProductosApi;
import com.cibertec.edu.springbootecommercedaw.repository.RESTProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RESTProductService {

    private RESTProductRepository restProductRepository;

    //Metodo Listar
    public List<ProductosApi> listarProductos(){
        return restProductRepository.findAll();
    }

    //Metodo Buscar por Id
    public ProductosApi obtenerProductoporId(Long id){
        return restProductRepository.findById(id).get();
    }

    //Metodo guardar
    public ProductosApi guardar(ProductosApi productosApi){
        return  restProductRepository.save(productosApi);
    }

    //Metodo eliminar
    public void eliminar(Long id){
        restProductRepository.deleteById(id);
    }


}
