package com.bd.ventas.servicios;

import java.util.List;

import com.bd.ventas.modelo.ClassEmpleado;

public interface IEmpleadoServicio {
	public List<ClassEmpleado> ListarEmpleado();
	public ClassEmpleado verificarCredenciales(String username, String password);
	
}
