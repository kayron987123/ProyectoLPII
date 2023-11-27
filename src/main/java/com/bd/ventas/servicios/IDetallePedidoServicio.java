package com.bd.ventas.servicios;

import java.util.List;

import com.bd.ventas.modelo.ClassDetallePedido;

public interface IDetallePedidoServicio {
	public List<ClassDetallePedido> ListarDetallePedido();
	public void RegistrarDetallePedido(ClassDetallePedido detallepe);
	public ClassDetallePedido BuscarPorId(Integer id);
	public void EliminarDetallePedido(Integer id);
}
