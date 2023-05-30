package com.gse.pruebaService.services;

import java.util.List;
import java.util.Optional;

import com.gse.pruebaService.model.Prueba;
import com.gse.pruebaService.services.DTO.PruebaDTO;

public interface IPruebaService {
	public List<PruebaDTO> listar();
	public PruebaDTO obtenerPorId(Integer id);
	public PruebaDTO save(PruebaDTO prueba);
	public boolean eliminar(Integer id);
	
	//Ejercicios de la prueba
	
	
}
