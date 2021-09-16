package com.everis.data.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Empleado;
import com.everis.data.services.EmpleadoService;
import com.everis.data.services.ProyectoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	//dependencia servicio
	/*private final EmpleadoService gato;
	
	public EmpleadoController(EmpleadoService empleadoService) {
		this.gato = empleadoService;
	}*/
	@Autowired
	private EmpleadoService gato;
	
	@Autowired
	private ProyectoService proyectoService;
	
//@ModelAttribute("empleado") Empleado empleado, ejemplo pasar entidad a un jsp
	@RequestMapping("")
	public String index(@ModelAttribute("empleado") Empleado empleado,Model model ) {
		System.out.println("index");
		
		List<Empleado> lista_empleados = gato.findAll();
		model.addAttribute("lista_empleados", lista_empleados);
		model.addAttribute("lista_proyectos", proyectoService.findAll());
		
		return "empleado.jsp";
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("empleado") Empleado empleado) {
		System.out.println("crear "+ empleado);
		//llamado a guardar la entidad
	
		gato.insertarEmpleado(empleado);
		return "redirect:/empleado";
	}
//METODO ACTUALIZAR	
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: "+ id);
		
		Empleado empleado = gato.buscarEmpleado(id);
		
		model.addAttribute("empleado", empleado);
		model.addAttribute("lista_proyectos", proyectoService.findAll());
		return "editar_empleado.jsp";
	}
	
	@RequestMapping(value="/modificar",method= RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("empleado") Empleado empleado) {
		
		System.out.println("el Id a modificar es: "+empleado.getId());
		gato.modificarEmpleado(empleado);
		
		return "redirect:/empleado";
	}

//METODOS ELIMINAR	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		System.out.println("Eliminar id: "+ id);
		gato.eliminarEmpleado(id);
		
		return "redirect:/empleado";
	}
	
	
	@RequestMapping(value="/eliminar2/{id}", method = RequestMethod.DELETE)
	public String eliminar2(@PathVariable("id") Long id) {
		System.out.println("Eliminar2 id: "+ id);
		gato.eliminarEmpleado(id);
		
		return "redirect:/empleado";
	}
	
	
	@RequestMapping("/buscar")
	public String buxcar() {
		return "redirect:/empleado";
	}
}
