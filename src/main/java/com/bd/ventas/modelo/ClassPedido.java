package com.bd.ventas.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_pedido")
public class ClassPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpedido;
	@ManyToOne
	@JoinColumn(name="empleado")
	private ClassEmpleado empleado;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechapedido;
	private String estado;
	private String metodopago;
	private double total;
	
	public ClassPedido() {
		
	}
	
	public ClassPedido(int idpedido, ClassEmpleado empleado, Date fechapedido, String estado, String metodopago,
			double total) {
		super();
		this.idpedido = idpedido;
		this.empleado = empleado;
		this.fechapedido = fechapedido;
		this.estado = estado;
		this.metodopago = metodopago;
		this.total = total;
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public ClassEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(ClassEmpleado empleado) {
		this.empleado = empleado;
	}

	public Date getFechapedido() {
		return fechapedido;
	}

	public void setFechapedido(Date fechapedido) {
		this.fechapedido = fechapedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMetodopago() {
		return metodopago;
	}

	public void setMetodopago(String metodopago) {
		this.metodopago = metodopago;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "" + idpedido ;
	}
	
	
}
