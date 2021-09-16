package com.everis.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Cuenta;
import com.everis.data.repositories.CuentaRepository;

@Service
public class CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;
	
	public Cuenta findBiId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Cuenta> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public void save(Cuenta cuenta) {

		
		if(!cuenta.getEstado().equals("")) {
			cuentaRepository.save(cuenta);
		}else {
			System.out.println("No puede ser vacio");
		}
		
		
		
	}

	

}
