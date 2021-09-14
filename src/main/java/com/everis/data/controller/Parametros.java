package com.everis.data.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Parametros {
	
	@RequestMapping("/parametro")
	public String inicio(@RequestParam(value="x") String parametro ) {
		return "Parametro pasado: "+ parametro;
	}

	@RequestMapping("/parametro2")
	public String inicio2(@RequestParam(value="x",required = false) String parametro ) {
		if(parametro == null) {
			return "el parametro es nulo";
		}
		return "Parametro2 pasado: "+ parametro;
	}
	
	//{valor} debe ser igual al nombre de @PathVariable("valor")
	@RequestMapping("/parametro3/{valor}")
	public String parametro3(@PathVariable("valor") String valor ) {
		return "el valor en el path es: " + valor;
	}
	
	//POST
	@RequestMapping("/parametro4/{valor}/{valor2}")
	public String parametro4(@PathVariable("valor") String valor, 
			@PathVariable("valor2") Integer valor2
			) {
		return "el valor en el path es: " + Integer.parseInt(valor)+ " "+ valor2;
	}
	

}
