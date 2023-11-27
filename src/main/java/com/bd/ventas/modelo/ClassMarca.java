package com.bd.ventas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_marca")
public class ClassMarca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmarca;
	private String nombre;
	
	public ClassMarca() {
		
	}
	
	public ClassMarca(int idmarca, String nombre) {
		super();
		this.idmarca = idmarca;
		this.nombre = nombre;
	}

	public int getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}
