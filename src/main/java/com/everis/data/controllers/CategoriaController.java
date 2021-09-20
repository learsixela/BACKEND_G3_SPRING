package com.everis.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Categoria;
import com.everis.data.services.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService cs;
	
	@RequestMapping("")
	public String inicio(Model model) {
		model.addAttribute("lista_categorias", cs.findAll());
		return "categoria.jsp";
	}
	
	@RequestMapping(value="/insertar", method = RequestMethod.POST)
	public String insertar(@RequestParam("nombre") String nombre) {
		Categoria categoria = new Categoria(nombre);
		
		cs.save(categoria);
		return "redirect:/categoria";
	}

}
