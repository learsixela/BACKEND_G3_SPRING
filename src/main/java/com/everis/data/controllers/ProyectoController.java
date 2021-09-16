package com.everis.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Proyecto;
import com.everis.data.services.ProyectoService;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {

	@Autowired
	private ProyectoService ps;
	
	@RequestMapping("")
	public String inicio(Model model) {
		model.addAttribute("lista_proyectos", ps.findAll());
		return "proyecto.jsp";
	}
	
	@RequestMapping(value="/insertar", method = RequestMethod.POST)
	public String insertar(@RequestParam("nombre") String nombre) {
		Proyecto proyecto = new Proyecto(nombre);
		
		ps.save(proyecto);
		return "redirect:/proyecto";
	}
}
