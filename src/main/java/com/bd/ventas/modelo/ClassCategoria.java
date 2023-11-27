package com.bd.ventas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_categoria")
public class ClassCategoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcategoria;
	private String nombre;
	
	public ClassCategoria() {
		
	}
	
	public ClassCategoria(int idcategoria, String nombre) {
		super();
		this.idcategoria = idcategoria;
		this.nombre = nombre;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
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
