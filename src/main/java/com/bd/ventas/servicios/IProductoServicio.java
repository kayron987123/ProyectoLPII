package com.bd.ventas.servicios;

import java.util.List;

import com.bd.ventas.modelo.ClassProducto;

public interface IProductoServicio {
	public List<ClassProducto> ListarProducto();
	public void RegistrarProducto(ClassProducto prod);
	public ClassProducto BuscarPorId(Integer id);
	public void EliminarProducto(Integer id);
}
