package com.everis.data.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class Home {

	@RequestMapping("")
	public String pagina() {
		return "Clase Lunes home";
	}
	
	@RequestMapping("/inicio")
	public String pagina2() {
		return "Clase Lunes home/inicio";
	}
	
	@RequestMapping("/inicio/otro")
	public String pagina3() {
		return "Clase Lunes home/inicio/otro";
	}
	
	@RequestMapping(value="/get",method = RequestMethod.GET)
	public String pagina4() {
		return "Clase Lunes home/get";
	}
	
}
