package com.everis.data.services;

import java.util.List;

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



	
	
	
}

// Controller -> Service
				//Service -> Repository	
//https://github.com/C3sar01/everisLab