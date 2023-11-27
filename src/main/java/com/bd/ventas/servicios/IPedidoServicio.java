package com.bd.ventas.servicios;

import java.util.List;

import com.bd.ventas.modelo.ClassPedido;

public interface IPedidoServicio {
	public List<ClassPedido> ListarPedidos();
	public void RegistrarPedido(ClassPedido pedido);
	public ClassPedido BuscarPorId(Integer id);
	public void EliminarPedido(Integer id);
}
