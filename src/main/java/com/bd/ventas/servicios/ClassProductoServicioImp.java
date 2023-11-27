package com.bd.ventas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.ventas.modelo.ClassProducto;
import com.bd.ventas.repositorios.IProductoRepository;

@Service
public class ClassProductoServicioImp implements IProductoServicio{
	
	@Autowired
	private IProductoRepository iproductorepository;
	
	@Override
	public List<ClassProducto> ListarProducto() {
		return (List<ClassProducto>) iproductorepository.findAll();
	}

	@Override
	public void RegistrarProducto(ClassProducto producto) {
		iproductorepository.save(producto);
	}

	@Override
	public ClassProducto BuscarPorId(Integer id) {
		return iproductorepository.findById(id).orElse(null);
	}

	@Override
	public void EliminarProducto(Integer id) {
		iproductorepository.deleteById(id);
	}

}
