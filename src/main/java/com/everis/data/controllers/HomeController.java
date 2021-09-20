package com.everis.data.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.User;


@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "login.jsp";
	}
	
	//pasar parametro desde el backend al frontend (Model model)
	@RequestMapping("/clase")
	public String pagina1(Model model) {
		model.addAttribute("parametro1", "clase everis lunes am");
		model.addAttribute("parametro2", "esto es otro parametro");
		model.addAttribute("titulo", "titulo 2");
		model.addAttribute("errorEmail", "No ha ingresado email");
		return "index.jsp";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(@RequestParam(value="email") String email,
			@RequestParam(value="password") String password) {
		
		System.out.println("parametros recibidos get: "+email+" "+ password);
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String loginPost(@RequestParam(value="email") String email,
			@RequestParam(value="password") String password) {
		
		System.out.println("parametros recibidos Post: "+email+" "+ password);
		
		return "index.jsp";
	}
	
	
}
