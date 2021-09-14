package com.everis.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado,Long>{
	//plantilla
	//interaccion con la base datos
	//metodos que heredaremos de otras clases (Crud y Jpa)
	
}
