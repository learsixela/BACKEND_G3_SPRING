package com.everis.data.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.everis.data.models.Empleado;
import com.everis.data.services.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	//dependencia servicio
	private final EmpleadoService es;
	
	public EmpleadoController(EmpleadoService empleadoService) {
		this.es = empleadoService;
	}
	
//@ModelAttribute("empleado") Empleado empleado, ejemplo pasar entidad a un jsp
	@RequestMapping("")
	public String index(@ModelAttribute("empleado") Empleado empleado ) {
		System.out.println("index");
		//Empleado empleado2 = new Empleado();
		//model.addAttribute(new Empleado());
		return "empleado.jsp";
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("empleado") Empleado empleado) {
		System.out.println("crear "+ empleado.getNombre());
		return "empleado.jsp";
	}
	
	@RequestMapping("/actualizar")
	public String actualizar() {
		return "empleado.jsp";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar() {
		return "empleado.jsp";
	}
	
	@RequestMapping("/buscar")
	public String buxcar() {
		return "empleado.jsp";
	}
}
