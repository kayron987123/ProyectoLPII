package com.bd.ventas.repositorios;


import org.springframework.data.repository.CrudRepository;

import com.bd.ventas.modelo.ClassEmpleado;

public interface IEmpleadoRepository extends CrudRepository<ClassEmpleado, Integer>{
	ClassEmpleado findByUsernameAndContrasena(String username, String contrasena);
}
