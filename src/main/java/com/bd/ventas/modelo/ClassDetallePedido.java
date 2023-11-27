package com.bd.ventas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_detallepedido")
public class ClassDetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddetalle;
	@ManyToOne
	@JoinColumn(name = "pedido")
	private ClassPedido pedido;
	@ManyToOne
	@JoinColumn(name = "producto")
	private ClassProducto producto;
	@ManyToOne
	@JoinColumn(name = "cliente")
	private ClassClientes cliente;
	private int cantidad;
	private double preciounitario;
	
	public ClassDetallePedido() {
		
	}
	
	public ClassDetallePedido(int iddetalle, ClassPedido pedido, ClassProducto producto, ClassClientes cliente,
			int cantidad, double preciounitario) {
		super();
		this.iddetalle = iddetalle;
		this.pedido = pedido;
		this.producto = producto;
		this.cliente = cliente;
		this.cantidad = cantidad;
		this.preciounitario = preciounitario;
	}

	public int getIddetalle() {
		return iddetalle;
	}

	public void setIddetalle(int iddetalle) {
		this.iddetalle = iddetalle;
	}

	public ClassPedido getPedido() {
		return pedido;
	}

	public void setPedido(ClassPedido pedido) {
		this.pedido = pedido;
	}

	public ClassProducto getProducto() {
		return producto;
	}

	public void setProducto(ClassProducto producto) {
		this.producto = producto;
	}

	public ClassClientes getCliente() {
		return cliente;
	}

	public void setCliente(ClassClientes cliente) {
		this.cliente = cliente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(double preciounitario) {
		this.preciounitario = preciounitario;
	}

	@Override
	public String toString() {
		return "ClassDetallePedido [iddetalle=" + iddetalle + ", pedido=" + pedido + ", producto=" + producto
				+ ", cliente=" + cliente + ", cantidad=" + cantidad + ", preciounitario=" + preciounitario + "]";
	}
	
	
	
}
