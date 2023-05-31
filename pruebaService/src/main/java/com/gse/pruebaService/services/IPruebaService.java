package com.gse.pruebaService.services;

import java.util.List;
import java.util.Optional;

import com.gse.pruebaService.model.Prueba;
import com.gse.pruebaService.services.DTO.PruebaDTO;

public interface IPruebaService {
	public List<PruebaDTO> listar();
	public PruebaDTO save(PruebaDTO prueba);
	public boolean eliminar(Integer id);
	
	//Ejercicios de la prueba
	
	public boolean palabraPalindroma(String palabra, PruebaDTO prueba);
	public List<Integer> serieFibonacci(int rango, PruebaDTO prueba);
	public boolean parImpar(int numero, PruebaDTO prueba);
	public String multiplosValor(int X, int rango, PruebaDTO prueba);
	public int facorial(int numero, PruebaDTO prueba);
	
	//Metodo recursivo
	public int factorialRecursivoService(int numero, PruebaDTO prueba);
	
}
