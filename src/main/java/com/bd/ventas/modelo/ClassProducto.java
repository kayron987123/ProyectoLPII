package com.bd.ventas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_producto")
public class ClassProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproducto;
	private String nombre;
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="marca")
	private ClassMarca marca;
	@ManyToOne
	@JoinColumn(name="categoria")
	private ClassCategoria categoria;
	private double precio;
	private int stock;
	
	public ClassProducto() {
		
	}
	
	public ClassProducto(int idproducto, String nombre, String descripcion, ClassMarca marca, ClassCategoria categoria,
			double precio, int stock) {
		super();
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.categoria = categoria;
		this.precio = precio;
		this.stock = stock;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ClassMarca getMarca() {
		return marca;
	}

	public void setMarca(ClassMarca marca) {
		this.marca = marca;
	}

	public ClassCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(ClassCategoria categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return  nombre;
	}
	
	
}
