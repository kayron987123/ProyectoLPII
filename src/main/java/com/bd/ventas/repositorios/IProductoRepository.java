package com.bd.ventas.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.bd.ventas.modelo.ClassProducto;

public interface IProductoRepository extends CrudRepository<ClassProducto, Integer>{

}
