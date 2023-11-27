package com.bd.ventas.servicios;

import java.util.List;

import com.bd.ventas.modelo.ClassClientes;

public interface IClientesServicio {
	List<ClassClientes> ListarClientes();
	public void RegistrarCliente(ClassClientes cliente);
	public ClassClientes BuscarPorId(Integer id);
	public void EliminarCliente(Integer id);
}
