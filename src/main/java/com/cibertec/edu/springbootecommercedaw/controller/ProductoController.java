package com.cibertec.edu.springbootecommercedaw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cibertec.edu.springbootecommercedaw.model.Product;
import com.cibertec.edu.springbootecommercedaw.model.ProductCategory;
import com.cibertec.edu.springbootecommercedaw.request.ProductRequest;
import com.cibertec.edu.springbootecommercedaw.response.ResultadoResponse;
import com.cibertec.edu.springbootecommercedaw.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductoController {

	@Autowired
	private ProductService productService;

	// Metodo Listar Productos
	@GetMapping("/frmProduct")
	public String frmProduct(Model model) {
		model.addAttribute("lstProductos", productService.listarProductos());
		return "product/frmProduct";
	}

	// Metodo Listar Productos Filtro
	@GetMapping("/frmProductFiltro")
	public String frmProductFiltro(Model model) {
		model.addAttribute("lstProductos", productService.listarProductos());
		return "product/frmProductFiltro";
	}

	// Metodo Listar Productos Reporte
	@GetMapping("/frmProductReporte")
	public String frmProductReporte(Model model) {
		model.addAttribute("lstProductos", productService.listarProductos());
		return "product/frmProductReporte";
	}

	// Metodo Registrar Producto
	@PostMapping("/registrarProducto")
	@ResponseBody
	public ResultadoResponse registrarProducto(@RequestBody ProductRequest productRequest) {
		String mensaje = "Producto registrado correctamente";
		Boolean respuesta = true;
		try {
			Product objProducto = new Product();
			if (productRequest.getId_product() > 0) {
				objProducto.setId_product(productRequest.getId_product());
			}
			// Se registrar el id porque no es autogenerado
			objProducto.setId_product(productRequest.getId_product());
			objProducto.setName(productRequest.getName());
			objProducto.setSku(productRequest.getSku());
			objProducto.setDescription(productRequest.getDescription());
			objProducto.setUnit_price(productRequest.getUnit_price());
			objProducto.setImage_url(productRequest.getImage_url());
			objProducto.setUnits_in_stock(productRequest.getUnits_in_stock());
			objProducto.setDate_created(productRequest.getDate_created());
			objProducto.setLast_updated(productRequest.getLast_updated());
			ProductCategory objProductCategory = new ProductCategory();
			objProductCategory.setId(productRequest.getId());
			objProducto.setCategory(objProductCategory);
			productService.registrarProductos(objProducto);
		} catch (Exception ex) {
			mensaje = "No se pudo registrar el producto";
			respuesta = false;
		}
		return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
	}

	// Metodo Eliminar Categoria
	@DeleteMapping("/eliminarProducto")
	@ResponseBody
	public ResultadoResponse eliminarProducto(@RequestBody ProductRequest productRequest) {
		String mensaje = "Producto eliminado correctamente";
		Boolean respuesta = true;
		try {
			productService.eliminarProducto(productRequest.getId_product());
		} catch (Exception e) {
			mensaje = "Producto no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
	}


	@GetMapping("/listarProductos")
	@ResponseBody
	public List<Product> listarProductos() {
		return productService.listarProductos();
	}

}
