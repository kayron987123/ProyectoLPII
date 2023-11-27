package com.bd.ventas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_empleado")
public class ClassEmpleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idempleado;
	private String nombre;
	private String username;
	private String contrasena;
	private String cargo;
	
	public ClassEmpleado() {
		
	}

	public ClassEmpleado(int idempleado, String nombre, String username, String contrasena, String cargo) {
		super();
		this.idempleado = idempleado;
		this.nombre = nombre;
		this.username = username;
		this.contrasena = contrasena;
		this.cargo = cargo;
	}

	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}
