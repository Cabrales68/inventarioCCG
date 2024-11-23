package com.cabrales.inventario.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles", schema = "public")
public class Rol {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id_rol")
	private Integer idRol;
	
	
	private String rol;
	
	 @ManyToOne
	    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus") 
	    private Estatus estatus;

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	
	  public Rol() {
	  }
	  
	public Rol(Integer idRol, String rol, Estatus estatus) {
		this.idRol = idRol;
		this.rol = rol;
		this.estatus = estatus;
	}
	
	
	
	
	
	

	
	
	
}
