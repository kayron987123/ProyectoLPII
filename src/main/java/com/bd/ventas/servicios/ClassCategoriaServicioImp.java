package com.bd.ventas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.ventas.modelo.ClassCategoria;
import com.bd.ventas.repositorios.ICategoriaRepository;

@Service
public class ClassCategoriaServicioImp implements ICategoriaServicio{

	@Autowired
	private ICategoriaRepository icategoriarepository;
	
	@Override
	public List<ClassCategoria> ListarCategoria() {
		return (List<ClassCategoria>) icategoriarepository.findAll();
	}

}
