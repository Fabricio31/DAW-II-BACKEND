package com.cibertec.edu.springbootecommercedaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cibertec.edu.springbootecommercedaw.model.Consoles;
import com.cibertec.edu.springbootecommercedaw.model.Product;
import com.cibertec.edu.springbootecommercedaw.model.ProductCategory;
import com.cibertec.edu.springbootecommercedaw.request.ConsoleRequest;
import com.cibertec.edu.springbootecommercedaw.response.ResultadoResponse;
import com.cibertec.edu.springbootecommercedaw.service.ConsolesService;

@Controller
@RequestMapping("/console")
public class ConsolesController {

	@Autowired
	private ConsolesService consolesService;

	@GetMapping("/frmConsole")
	public String frmConsole(Model model) {
		model.addAttribute("lstConsolas", consolesService.listarConsolas());
		return "console/frmConsole";
	}

	
	@PostMapping("/registrarConsoles")
	@ResponseBody
	public ResultadoResponse registrarConsoles(@RequestBody ConsoleRequest consoleRequest) {
		String mensaje = "Consola registrada correctamente";
		Boolean respuesta = true;
		try {
			Consoles objConsoles = new Consoles();
			if (consoleRequest.getId_console()> 0) {
				objConsoles.setId_console(consoleRequest.getId_console());
			}
			objConsoles.setId_console(consoleRequest.getId_console());
			objConsoles.setName_console(consoleRequest.getName_console());
			objConsoles.setDescription(consoleRequest.getDescription());
			objConsoles.setModel(consoleRequest.getModel());
			objConsoles.setYear(consoleRequest.getYear());
			
			Product objProduct = new Product();
			objProduct.setId_product(consoleRequest.getId_product());
			
			ProductCategory objProductCategory = new ProductCategory();
			objProductCategory.setId(consoleRequest.getId());
			
			objConsoles.setProduct(objProduct);
			objConsoles.setProduct_category(objProductCategory);
			
			consolesService.registrarConsola(objConsoles);
			
		} catch (Exception e) {
			mensaje = "No se pudo registrar la consola";
			respuesta = false;
		}
		return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
	
	
	
	
	
	}

}
