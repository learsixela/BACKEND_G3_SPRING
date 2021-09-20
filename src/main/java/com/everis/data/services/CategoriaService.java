package com.everis.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Categoria;
import com.everis.data.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository cr;

	public List<Categoria> findAll() {
		return cr.findAll();
	}

	public void save(Categoria categoria) {
		cr.save(categoria);
	}


}
