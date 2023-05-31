package com.gse.pruebaService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gse.pruebaService.model.Prueba;
import com.gse.pruebaService.services.IPruebaService;
import com.gse.pruebaService.services.DTO.PruebaDTO;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
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
	
	@DeleteMapping("pruebas/{id}")
	public boolean delete(@PathVariable Integer id) {
		boolean resultado = pruebaService.eliminar(id);
		return resultado;
	}
	
	@PostMapping("/palindormo/{palabra}")
	public boolean palindormo(@PathVariable String palabra,@RequestBody PruebaDTO prueba) {
		boolean resultado = pruebaService.palabraPalindroma(palabra, prueba);
		return resultado;
	}
	
	@PostMapping("/fibonacci/{numero}")
	public List<Integer> fibonacci(@PathVariable Integer numero,@RequestBody PruebaDTO prueba) {
		List<Integer> numeros = pruebaService.serieFibonacci(numero, prueba);
		return numeros;
	}
	
	@PostMapping("/parimpar/{numero}")
	public boolean parImpar(@PathVariable Integer numero,@RequestBody PruebaDTO prueba) {
		boolean resultado;
		resultado = pruebaService.parImpar(numero, prueba);
		return resultado;
	}
	
	@PostMapping("/factorial/{numero}")
	public int factorial(@PathVariable Integer numero,@RequestBody PruebaDTO prueba) {
		int resultado;
		resultado = pruebaService.facorial(numero, prueba);
		return resultado;
	}
	
	@PostMapping("/multiplos/{numero}/{rango}")
	public String multiplosValor(@PathVariable Integer numero,@PathVariable Integer rango,@RequestBody PruebaDTO prueba) {
		String resultado;
		resultado = pruebaService.multiplosValor(numero, rango, prueba);
		return resultado;
	}
	
	@PostMapping("/factorialrecursivo/{numero}")
	public int factorialRecursivo(@PathVariable Integer numero,@RequestBody PruebaDTO prueba) {
		int resultado;
		resultado = pruebaService.factorialRecursivoService(numero, prueba);
		return resultado;
	}
	
}
