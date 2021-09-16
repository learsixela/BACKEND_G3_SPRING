package com.everis.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Proyecto;
import com.everis.data.repositories.ProyectoRepository;

@Service
public class ProyectoService {
	@Autowired
	private ProyectoRepository pr;
	
	
	public List<Proyecto> findAll(){
		return pr.findAll();
	}
	
	public void save(Proyecto proyecto) {
		pr.save(proyecto);
	}

}
