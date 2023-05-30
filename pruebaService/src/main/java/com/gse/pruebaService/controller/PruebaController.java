package com.gse.pruebaService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gse.pruebaService.model.Prueba;
import com.gse.pruebaService.services.IPruebaService;
import com.gse.pruebaService.services.DTO.PruebaDTO;

@RestController
@RequestMapping("/api")
public class PruebaController {
	
	@Autowired
	private IPruebaService pruebaService;
	
	@GetMapping("/pruebas")
	public List<PruebaDTO> index(){
		return pruebaService.listar();
	}
	
	@PostMapping("/pruebas")
	public PruebaDTO create(@RequestBody PruebaDTO prueba) {
		PruebaDTO objPrueba = null;
		objPrueba = pruebaService.save(prueba);
		return objPrueba;
	}
	
}
