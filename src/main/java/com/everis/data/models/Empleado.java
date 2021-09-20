package com.everis.data.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	//relacion 1 a 1
	@OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Cuenta cuenta;
	
	//relacion 1 a n
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="proyecto_id")
	private Proyecto proyecto;
	
	//relacion n a m
	//tabla intermedia
	//JoinTable-> name; joincolumns; inverseJoinColumns
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="categorias_empleados",
	joinColumns = @JoinColumn(name="empleado_id"),
	inverseJoinColumns =  @JoinColumn(name="categoria_id"))
	private List<Categoria> categorias;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
    @PrePersist //se ejecuta antes de que sea insertado
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate // se ejecuta antes de que sea actualizado
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


}
