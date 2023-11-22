package com.cibertec.edu.springbootecommercedaw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cibertec.edu.springbootecommercedaw.model.Categories;
import com.cibertec.edu.springbootecommercedaw.model.Consoles;
import com.cibertec.edu.springbootecommercedaw.model.Games;
import com.cibertec.edu.springbootecommercedaw.model.Platforms;
import com.cibertec.edu.springbootecommercedaw.model.Product;
import com.cibertec.edu.springbootecommercedaw.model.ProductCategory;
import com.cibertec.edu.springbootecommercedaw.request.GamesRequest;
import com.cibertec.edu.springbootecommercedaw.response.ResultadoResponse;
import com.cibertec.edu.springbootecommercedaw.service.GamesService;



@Controller
@RequestMapping("/games")
public class GamesController {

	@Autowired
	private GamesService gamesService;

	@GetMapping("/frmGames")
	public String frmGames(Model model) {
		model.addAttribute("lstJuegos", gamesService.listarJuegos());
		return "games/frmGames";
	}

	@PostMapping("/registrarJuego")
	@ResponseBody
	public ResultadoResponse registrarJuego(@RequestBody GamesRequest gamesRequest) {
		String mensaje = "Juego registrado correctamente";
		Boolean respuesta = true;
		
		try {
			Games objJuego = new Games();
			if(gamesRequest.getId_game() > 0) {
				objJuego.setId_game(gamesRequest.getId_game());
			}
			objJuego.setId_game(gamesRequest.getId_game());
			objJuego.setName(gamesRequest.getName());
			objJuego.setDescription(gamesRequest.getDescription());
			Consoles objConsole = new Consoles();
			objConsole.setId_console(gamesRequest.getId_console());
			Categories objCategories = new Categories();
			objCategories.setId_category(gamesRequest.getId_category());
			Platforms objPlataforma = new Platforms();
			objPlataforma.setId_platforms(gamesRequest.getId_platforms());
			Product objProduct = new Product();
			objProduct.setId_product(gamesRequest.getId_product());
			ProductCategory objProductCategory = new ProductCategory();
			objProductCategory.setId(gamesRequest.getId());
			
			objJuego.setConsoles(objConsole);
			objJuego.setCategories(objCategories);
			objJuego.setPlatforms(objPlataforma);
			objJuego.setProduct(objProduct);
			objJuego.setCategory(objProductCategory);
			
			
			gamesService.registrarJuegos(objJuego);
		
		} catch (Exception ex) {
			 mensaje = "Juego no registrado :c ";
			 respuesta = false;
		}
		return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
	}
	
	@DeleteMapping("/eliminarJuego")
	@ResponseBody
	public ResultadoResponse eliminarJuego(@RequestBody GamesRequest juegoRequest) {
		String mensaje = "Juego eliminado correctamente";
		Boolean respuesta = true;
		
		try {
			gamesService.eliminarJuegos(juegoRequest.getId_game());
		} catch (Exception e) {
			 mensaje = "Juego no eliminado ";
			 respuesta = false;
		}
		return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();		
	}
	
	
	@GetMapping("/listarJuegos")
	@ResponseBody
	public List<Games> listarJuegos(){
		return gamesService.listarJuegos();
	}
	
	
	

}
