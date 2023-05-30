package com.gse.pruebaService.services.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PruebaDTO {
	
	private Integer id;
	
	private String fecha_hora_prueba;
	
	private String palabra_variables;
	
	private String resultado;
	
	private String tipo_prueba;
	
	
	public PruebaDTO() {
		
	}

	public PruebaDTO(Integer id, String fecha_hora_prueba, String palabra_variables, String resultado,
			String tipo_prueba) {
		this.id = id;
		this.fecha_hora_prueba = fecha_hora_prueba;
		this.palabra_variables = palabra_variables;
		this.resultado = resultado;
		this.tipo_prueba = tipo_prueba;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the fecha_hora_prueba
	 */
	public String getFecha_hora_prueba() {
		return fecha_hora_prueba;
	}

	/**
	 * @param fecha_hora_prueba the fecha_hora_prueba to set
	 */
	public void setFecha_hora_prueba(String fecha_hora_prueba) {
		this.fecha_hora_prueba = fecha_hora_prueba;
	}

	/**
	 * @return the palabra_variables
	 */
	public String getPalabra_variables() {
		return palabra_variables;
	}

	/**
	 * @param palabra_variables the palabra_variables to set
	 */
	public void setPalabra_variables(String palabra_variables) {
		this.palabra_variables = palabra_variables;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the tipo_prueba
	 */
	public String getTipo_prueba() {
		return tipo_prueba;
	}

	/**
	 * @param tipo_prueba the tipo_prueba to set
	 */
	public void setTipo_prueba(String tipo_prueba) {
		this.tipo_prueba = tipo_prueba;
	}
	
	
}
