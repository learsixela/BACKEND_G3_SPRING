package com.everis.data.services;

import org.springframework.stereotype.Service;

import com.everis.data.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

	//logica de negocio o empresarial
	//dependencia repository
	private final EmpleadoRepository er;
	
	public EmpleadoService(EmpleadoRepository empleadoRepository) {
		this.er = empleadoRepository;
	}
}

// Controller -> Service
				//Service -> Repository	
//https://github.com/C3sar01/everisLab