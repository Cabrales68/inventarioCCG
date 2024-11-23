package com.cabrales.inventario.dto;


import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Usuarios {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer idUsuario;
	
	
	private String usuario;
	private String nombre;
	private String apellido;
	
	private LocalDateTime  fechaCreacion;
	
	@ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol") 
    private Rol rol;
	
	@ManyToOne
    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus") 
    private Estatus estatus;

	
	private String password;


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDateTime  fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public Estatus getEstatus() {
		return estatus;
	}


	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	
	public Usuarios() {
		
	}
	
	public Usuarios(Integer idUsuario, String usuario, String nombre, String apellido, LocalDateTime  fechaCreacion, Rol rol,
			Estatus estatus, String password) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaCreacion = fechaCreacion;
		this.rol = rol;
		this.estatus = estatus;
		this.password = password;
	}
	
	
	
	
}
