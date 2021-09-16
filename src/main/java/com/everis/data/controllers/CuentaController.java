package com.everis.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Cuenta;
import com.everis.data.models.Empleado;
import com.everis.data.repositories.CuentaRepository;
import com.everis.data.services.CuentaService;
import com.everis.data.services.EmpleadoService;

@Controller
@RequestMapping("/cuenta")
public class CuentaController {

	@Autowired
	private EmpleadoService es;
	
	@Autowired
	private CuentaService cs;
	
	@Autowired
	private CuentaRepository cuentaRepository; 
	
	@RequestMapping("")
	public String inicio(Model model) {
		model.addAttribute("lista_empleados", es.findAll());
		model.addAttribute("empleado", new Empleado());
		return "cuenta.jsp";
	}
	
	@RequestMapping(value="/insertar", method = RequestMethod.POST)
	public String insertar(@RequestParam("codigo") String codigo,
							@RequestParam("estado") String estado,
							@RequestParam("empleados") Long id) {
		
		Empleado empleado = es.buscarEmpleado(id);
		
		System.out.println(codigo+" "+estado+" "+empleado);
		
		Cuenta cuenta = new Cuenta(codigo,estado,empleado);
		
		cs.save(cuenta);
		return "";
	}
}
