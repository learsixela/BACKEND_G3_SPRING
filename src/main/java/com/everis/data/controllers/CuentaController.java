package com.everis.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.data.models.Empleado;
import com.everis.data.services.EmpleadoService;

@Controller
@RequestMapping("/cuenta")
public class CuentaController {

	@Autowired
	private EmpleadoService es;
	
	@RequestMapping("")
	public String inicio(Model model) {
		model.addAttribute("lista_empleados", es.findAll());
		model.addAttribute("empleado", new Empleado());
		return "cuenta.jsp";
	}
}
