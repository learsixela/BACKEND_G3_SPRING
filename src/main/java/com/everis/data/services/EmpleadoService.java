package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.everis.data.models.Empleado;
import com.everis.data.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

	//logica de negocio o empresarial
	//dependencia repository
	private final EmpleadoRepository er;
	
	public EmpleadoService(EmpleadoRepository empleadoRepository) {
		this.er = empleadoRepository;
	}

	public Empleado insertarEmpleado(@Valid Empleado empleado) {
		// TODO Auto-generated method stub
		return er.save(empleado);
	}

	public List<Empleado> findAll() {
		// retorna una lista de empleados
		return er.findAll();
	}

	public void eliminarEmpleado(Long id) {
		er.deleteById(id);
	}

	public Empleado buscarEmpleado(Long id) {

		Optional<Empleado> oEmpleado= er.findById(id);
		
		if(oEmpleado.isPresent()) {
			return oEmpleado.get();
		}
		
		return null;
	}

	public void modificarEmpleado(@Valid Empleado empleado) {
		er.save(empleado);
		
	}



	
	
	
}

// Controller -> Service
				//Service -> Repository	
//https://github.com/C3sar01/everisLab