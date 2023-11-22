package com.cibertec.edu.springbootecommercedaw.controller;


import com.cibertec.edu.springbootecommercedaw.model.ProductosApi;
import com.cibertec.edu.springbootecommercedaw.service.RESTProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/rest-productos")
public class ApiController {


    private RESTProductService productService;


    //Metodo Listar
    @GetMapping("")
    public ResponseEntity<List<ProductosApi>> listarJuegos() {
        List<ProductosApi> gamesList = new ArrayList<>();
        productService.listarProductos().forEach(gamesList::add);
        if (gamesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gamesList, HttpStatus.OK);
    }


    //Metodo Buscar Por Id
   /*
    @GetMapping("{id}")
    public ResponseEntity<ProductosApi>obtenerJuego(@PathVariable("id")Long id){
        ProductosApi restGames = productService.obtenerProductoporId(id);
        return new ResponseEntity<>(restGames, HttpStatus.OK);
    }
   * */




    //Metodo Guardar
    @PostMapping("")
    public ResponseEntity<ProductosApi> registrarCategoria(
            @RequestBody ProductosApi games
    ){
        return new ResponseEntity<>(
                productService.guardar(games), HttpStatus.CREATED
        );
    }


    //Metodo Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<ProductosApi> actualizarCategoria(@PathVariable("id") Long id, @RequestBody ProductosApi category) {
        ProductosApi oldCategory = productService.obtenerProductoporId(id);
        oldCategory.setName(category.getName());
        oldCategory.setSku(category.getSku());
        oldCategory.setDescription(category.getDescription());
        oldCategory.setUnit_price(category.getUnit_price());
        oldCategory.setImage_url(category.getImage_url());
        oldCategory.setUnits_in_stock(category.getUnits_in_stock());
        oldCategory.setDate_created(category.getDate_created());
        oldCategory.setLast_updated(category.getLast_updated());
        return new ResponseEntity<>(productService.guardar(oldCategory), HttpStatus.OK);
    }


    //Metodo Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable("id") Long id) {
        productService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }







}
