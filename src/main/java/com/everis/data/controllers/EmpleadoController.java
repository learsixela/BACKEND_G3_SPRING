package com.everis.data.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.everis.data.models.Empleado;
import com.everis.data.services.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	//dependencia servicio
	private final EmpleadoService gato;
	
	public EmpleadoController(EmpleadoService empleadoService) {
		this.gato = empleadoService;
	}
	
//@ModelAttribute("empleado") Empleado empleado, ejemplo pasar entidad a un jsp
	@RequestMapping("")
	public String index(@ModelAttribute("empleado") Empleado empleado,Model model ) {
		System.out.println("index");
		
		List<Empleado> lista_empleados = gato.findAll();
		model.addAttribute("lista_empleados", lista_empleados);
		
		return "empleado.jsp";
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("empleado") Empleado empleado) {
		System.out.println("crear "+ empleado);
		//llamado a guardar la entidad
	
		Empleado emp =  gato.insertarEmpleado(empleado);
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
