package com.bd.ventas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.ventas.modelo.ClassClientes;
import com.bd.ventas.repositorios.IClientesRepository;

@Service
public class ClassClientesServicioImp implements IClientesServicio{
	
	@Autowired
	private IClientesRepository iclassclientesrepository;

	@Override
	public List<ClassClientes> ListarClientes() {
		return (List<ClassClientes>) iclassclientesrepository.findAll();
	}

	@Override
	public void RegistrarCliente(ClassClientes cliente) {
		iclassclientesrepository.save(cliente);
	}

	@Override
	public ClassClientes BuscarPorId(Integer id) {
		return iclassclientesrepository.findById(id).orElse(null);
	}

	@Override
	public void EliminarCliente(Integer id) {
		iclassclientesrepository.deleteById(id);
	}

}
