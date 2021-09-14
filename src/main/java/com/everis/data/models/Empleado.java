package com.everis.data.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //representacion de entidad modelo
@Table(name="empleados")
public class Empleado {
	//id
	@Id //clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto incrementar
	private Long id;
	private String rut;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String profesion;
	private String cargo;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	public Empleado() {
		super();
	}

	public Empleado(String rut, String nombre, String apellido, Integer edad, String profesion, String cargo) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.profesion = profesion;
		this.cargo = cargo;
	}

	public String getRut() {
		return rut;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public String getProfesion() {
		return profesion;
	}

	public String getCargo() {
		return cargo;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
    @PrePersist //se ejecuta antes de que sea insertado
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate // se ejecuta antes de que sea actualizado
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}