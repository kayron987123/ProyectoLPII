package com.bd.ventas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.ventas.modelo.ClassDetallePedido;
import com.bd.ventas.repositorios.IDetalllePedidoRepository;

@Service
public class ClassDetallePedidoServicioImp implements IDetallePedidoServicio{
	
	@Autowired
	private IDetalllePedidoRepository idetallepedidorepository;

	@Override
	public List<ClassDetallePedido> ListarDetallePedido() {
		return (List<ClassDetallePedido>) idetallepedidorepository.findAll();
	}

	@Override
	public void RegistrarDetallePedido(ClassDetallePedido detallepe) {
		idetallepedidorepository.save(detallepe);
	}

	@Override
	public ClassDetallePedido BuscarPorId(Integer id) {
		return idetallepedidorepository.findById(id).orElse(null);
	}

	@Override
	public void EliminarDetallePedido(Integer id) {
		idetallepedidorepository.deleteById(id);
	}

}
