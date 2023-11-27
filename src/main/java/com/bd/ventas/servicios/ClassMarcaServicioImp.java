package com.bd.ventas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.ventas.modelo.ClassMarca;
import com.bd.ventas.repositorios.IMarcaRepository;

@Service
public class ClassMarcaServicioImp implements IMarcaServicio{

	@Autowired
	private IMarcaRepository imarcarepository;
	
	@Override
	public List<ClassMarca> ListarMarcas() {
		return (List<ClassMarca>) imarcarepository.findAll();
	}

}
