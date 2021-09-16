package com.everis.data.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="proyectos")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	//relacion one To many (1 a n)
	@OneToMany(mappedBy = "proyecto",fetch = FetchType.LAZY)
	private List<Empleado> empleados;
	
	//fechas
    @Column(updatable=false)
    @CreationTimestamp
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @UpdateTimestamp
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

	public Proyecto() {
		super();
	}

	public Proyecto(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
}
