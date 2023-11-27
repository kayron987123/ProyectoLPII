package com.bd.ventas.servicios;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.ventas.modelo.ClassEmpleado;
import com.bd.ventas.repositorios.IEmpleadoRepository;

@Service
public class ClassEmpleadoServicioImp implements IEmpleadoServicio{

	@Autowired
	private IEmpleadoRepository iempleadorepository;
	
	@Override
	public List<ClassEmpleado> ListarEmpleado() {
		return (List<ClassEmpleado>) iempleadorepository.findAll();
	}

	@Override
	public ClassEmpleado verificarCredenciales(String username, String password) {
		return iempleadorepository.findByUsernameAndContrasena(username, password);
	}



}
