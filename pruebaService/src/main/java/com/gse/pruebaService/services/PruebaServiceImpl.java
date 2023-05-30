package com.gse.pruebaService.services;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gse.pruebaService.model.Prueba;
import com.gse.pruebaService.repository.PruebaRepository;
import com.gse.pruebaService.services.DTO.PruebaDTO;


@Service
public class PruebaServiceImpl implements IPruebaService{
	
	@Autowired
	private PruebaRepository servicioAccesoBDPrueba;
	
	@Autowired
    private ModelMapper modelMapper;

	@Override
	public List<PruebaDTO> listar() {
		Iterable<Prueba> pruebaEstity = this.servicioAccesoBDPrueba.findAll();
		List<PruebaDTO> pruebasDTO = this.modelMapper.map(pruebaEstity, new TypeToken<List<PruebaDTO>>( ) {}.getType());

		return pruebasDTO;
	}

	@Override
	public PruebaDTO obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PruebaDTO save(PruebaDTO prueba) {
		
		String fecha_hora = obtenerFechaHora();
		prueba.setFecha_hora_prueba(fecha_hora);
		
		Prueba pruebaEntity = this.modelMapper.map(prueba, Prueba.class);
		Prueba objPruebaEntity = this.servicioAccesoBDPrueba.save(pruebaEntity);
		PruebaDTO pruebaDTO = this.modelMapper.map(objPruebaEntity, PruebaDTO.class);
		
		return pruebaDTO;
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String obtenerFechaHora() {
		LocalDateTime fecha_hora = LocalDateTime.now();
		System.out.println(fecha_hora);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = fecha_hora.format(formatter);
		System.out.println(formatDateTime);
		
		return formatDateTime;
	}
	
}
