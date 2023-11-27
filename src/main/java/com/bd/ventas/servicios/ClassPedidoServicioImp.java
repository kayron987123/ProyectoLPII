package com.bd.ventas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.ventas.modelo.ClassPedido;
import com.bd.ventas.repositorios.IPedidoRepository;

@Service
public class ClassPedidoServicioImp implements IPedidoServicio{
	
	@Autowired
	private IPedidoRepository ipedidorepository;

	@Override
	public List<ClassPedido> ListarPedidos() {
		return (List<ClassPedido>) ipedidorepository.findAll();
	}

	@Override
	public void RegistrarPedido(ClassPedido pedido) {
		ipedidorepository.save(pedido);
	}

	@Override
	public ClassPedido BuscarPorId(Integer id) {
		return ipedidorepository.findById(id).orElse(null);
	}

	@Override
	public void EliminarPedido(Integer id) {
		ipedidorepository.deleteById(id);
	}
}
