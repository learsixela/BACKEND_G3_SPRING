package com.everis.data.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.User;
import com.everis.data.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("user") User user) {
		return "registro.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session
			) {
		boolean exiteUsuario = userService.validarUser(email, password);
		if(exiteUsuario) {
			
		}
		
		
		return "";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@Valid @ModelAttribute("user") User user) {
		//llamar a las validaciones
		userService.save(user);
		return "redirect:/login";
	}
	

}
