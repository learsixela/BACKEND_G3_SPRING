package com.everis.data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.data.models.Empleado;
import com.everis.data.services.EmpleadoService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private EmpleadoService es;
	
	//http://localhost:8080/api/empleados
	@GetMapping("/empleados")
	public List<Empleado> obtenerEmpleados(){
		return es.findAll();
	}
	//http://localhost:8080/api/empleados/{id}
	@GetMapping("/empleados/{id}")
	public Empleado obtenerEmpleado(@PathVariable("id") Long id) {
		Empleado empleado = es.buscarEmpleado(id);
		if(empleado ==  null) {
			throw new RuntimeException("Usuario no encontrado: "+ id);
		}
		
		return empleado;
	}
	
	//http://localhost:8080/api/empleado/{id}
	@DeleteMapping("/empleado/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable("id") Long id) {
		
		Empleado empleado = es.buscarEmpleado(id);
		if(empleado ==  null) {
			return "Empleado no encontrado: "+ id;
		}
		
		es.eliminarEmpleado(id);
		return "Empleado eliminado de id:" + id;
	} 

	//http://localhost:8080/api/empleado/agregar
	@PostMapping("/empleado/agregar")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		empleado.setId(0L);
		
		es.insertarEmpleado(empleado);
		
		return empleado;
	}
	
	//http://localhost:8080/api/empleado/actualizar
	@PutMapping("/empleado/actualizar")
	public Empleado actualizarEmpleado(@RequestBody Empleado empleado) {
		
		es.insertarEmpleado(empleado);
		
		return empleado;
	}
	
	
}
