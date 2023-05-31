package com.gse.pruebaService.services;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
		Optional<Prueba> optional= this.servicioAccesoBDPrueba.findById(id);
		if (!optional.isPresent()) {
			return false;
		}else {
			Prueba objPrueba = optional.get();
			this.servicioAccesoBDPrueba.delete(objPrueba);
			return true;
		}

	}

	@Override
	public boolean palabraPalindroma(String palabra, PruebaDTO prueba) {
		System.out.println("Ingresando a verificar Palindormo");
		palabra = palabra.toLowerCase();
		palabra = palabra.replace(" ", "");
		boolean bandera = true;
		String palabra_invertida = invertirPalabra(palabra);
		
		for (int i = 0; i < palabra.length(); i++) {
			if(palabra.charAt(i) != palabra_invertida.charAt(i)) {
				bandera = false;
				break;
			}
		}
		
		prueba.setFecha_hora_prueba(obtenerFechaHora());
		if(bandera == true) {
			prueba.setResultado("Es una palabra palindorma");
		}else {
			prueba.setResultado("NO es una palabra palindorma");
		}
		
		Prueba pruebaEntity = this.modelMapper.map(prueba, Prueba.class);
		this.servicioAccesoBDPrueba.save(pruebaEntity);
		
		return bandera;
	}

	@Override
	public List<Integer> serieFibonacci(int rango, PruebaDTO prueba) {
		System.out.println("Ingresando a serie Fibonacci");
		List<Integer> listanumeros = new ArrayList<>();
		int aux1 = 0;
		int aux2 = 1;
		int fibonacci = 1;
		String cadena = "";
		
		if(rango <= 0) {
			cadena = "El rango ingresado debe ser mayor a 0";
		}else {
			for (int i = 0; i < rango; i++) {
				
				listanumeros.add(fibonacci);
				System.out.println(fibonacci);
				fibonacci = aux1 + aux2;
				aux1 = aux2;
				aux2 = fibonacci;	
			}
			
			cadena = listaEnCadena(listanumeros);
		}
		
		prueba.setFecha_hora_prueba(obtenerFechaHora());
		
		prueba.setResultado(cadena);
		Prueba pruebaEntity = this.modelMapper.map(prueba, Prueba.class);
		this.servicioAccesoBDPrueba.save(pruebaEntity);
		
		System.out.println(cadena);
		
		return listanumeros;
	}

	@Override
	public boolean parImpar(int numero, PruebaDTO prueba) {
		System.out.println("Ingresando a numero par o impar");
		prueba.setFecha_hora_prueba(obtenerFechaHora());
		String resultado = "";
		boolean bandera = false;
		if(numero % 2 == 0) {
			resultado = "El numero ingresado es par";
			bandera = true;
		}else {
			resultado = "El numero ingresado NO es par";
		}
		
		prueba.setResultado(resultado);
		Prueba pruebaEntity = this.modelMapper.map(prueba, Prueba.class);
		this.servicioAccesoBDPrueba.save(pruebaEntity);
		
		return bandera;
	}
	
	@Override
	public String multiplosValor(int X, int rango, PruebaDTO prueba) {
		System.out.println("Ingresando a multiplos de un numero");
		List<Integer> multiplos = new ArrayList<>();
		prueba.setFecha_hora_prueba(obtenerFechaHora());
		int contador = 0;
		String resultado = "";
		if(X<=0 || rango <=0) {
			resultado = "Los valores enviados deben ser mayor a cero";
		}else {
			for (int i = 0; i < rango; i++) {
				if(i%X == 0) {
					multiplos.add(i);
					contador = contador + 1;
				}
			}
			String cadena_numeros = listaEnCadena(multiplos);
			resultado = resultado +"Numero de multiplos: " +Integer.toString(contador)+ "    Lista de multiplos: " + cadena_numeros;
		}
		
		
		prueba.setResultado(resultado);
		Prueba pruebaEntity = this.modelMapper.map(prueba, Prueba.class);
		this.servicioAccesoBDPrueba.save(pruebaEntity);
		return resultado;
	}

	@Override
	public int facorial(int numero, PruebaDTO prueba) {
		System.out.println("Ingresando a factorial de un numero");
		int resultado = 1;
		
		if(numero < 0) {
			resultado = -1;
			prueba.setResultado("No se puede calcular el factorial de un numero negativo");
		}else {
			if(numero != 0) {		
				for (int i = 1; i <= numero; i++) {
					resultado = resultado * i;
				}
			}
			prueba.setResultado(Integer.toString(resultado));
		}
		
		prueba.setFecha_hora_prueba(obtenerFechaHora());
		
		Prueba pruebaEntity = this.modelMapper.map(prueba, Prueba.class);
		this.servicioAccesoBDPrueba.save(pruebaEntity);
		
		return resultado;
	}
	
	@Override
	public int factorialRecursivoService(int numero, PruebaDTO prueba) {
		System.out.println("Ingresando a factorial de un numero con recursividad");
		int resultado = factorialRecursivo(numero);
		prueba.setFecha_hora_prueba(obtenerFechaHora());
		prueba.setResultado(Integer.toString(resultado));
		Prueba pruebaEntity = this.modelMapper.map(prueba, Prueba.class);
		this.servicioAccesoBDPrueba.save(pruebaEntity);
				
		return resultado;
	}
	
	/**
	 * Metodo recursivo para obtener el factorial de un numero
	 * retorna el factorial de un numero 
	 */
	public int factorialRecursivo(int numero) {
		if(numero < 0) {
			return -1;
		}else if(numero == 0) {
		    return 1;
		}else{
		    return numero *  factorialRecursivo(numero-1);   
		}
	}
	
	/**
	 * Metodo para obtener la fecha y hora actual
	 * Retorna una cadena con la fecha y hora actual 
	 */
	public String obtenerFechaHora() {
		LocalDateTime fecha_hora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = fecha_hora.format(formatter);
		
		return formatDateTime;
	}
	
	/**
	 * Metodo para invertir una frase o palabra
	 * Retorna la cadena invertida
	*/
	public String invertirPalabra(String palabra) {
		String palabra_invertida = "";
		
		for (int i = palabra.length() - 1; i >= 0; i--) {
			palabra_invertida += palabra.charAt(i);
		}
		
		return palabra_invertida;
	}
	
	/**
	 * Metodo para convertir una lisa en una cadena
	 * retorna una cadena con con numeros separados por comas 
	 */
	public String listaEnCadena(List<Integer> lista) {
		String cadena = "";
		
		for (int j = 0; j < lista.size(); j++) {
			if(j!= lista.size()-1) {
				cadena = cadena + lista.get(j).toString() + "," ;
			}else {
				cadena = cadena + lista.get(j).toString();
			}
		}
		
		return cadena;
	}

	
}
