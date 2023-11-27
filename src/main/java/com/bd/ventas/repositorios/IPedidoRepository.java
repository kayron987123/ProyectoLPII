package com.bd.ventas.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.bd.ventas.modelo.ClassPedido;

public interface IPedidoRepository extends CrudRepository<ClassPedido, Integer>{

}
