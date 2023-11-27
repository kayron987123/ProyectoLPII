package com.bd.ventas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.ventas.modelo.ClassClientes;
import com.bd.ventas.servicios.IClientesServicio;

@Controller
@RequestMapping("/Vistas")
public class ClientesController {
	
	@Autowired
	private IClientesServicio iclientesservicio;
	
	@GetMapping("/ListaClientes")
	private String ListarProductos(Model modelo) {
		
		List<ClassClientes> listaclientes = iclientesservicio.ListarClientes();
		
		modelo.addAttribute("listaclientes", listaclientes);
		
		return "/Vistas/ListaClientes";
	}
	
	
	@GetMapping("/RegistrarCliente")
	private String RegistrarCliente(Model modelo) {
		
		ClassClientes cliente = new ClassClientes();
		
		modelo.addAttribute("cliente", cliente);
		
		return "/Vistas/RegistrarClientes";
	}
	
	@PostMapping("/GuardarCliente")
	private String GuardarCliente(@ModelAttribute ClassClientes cliente,Model model) {
		
		iclientesservicio.RegistrarCliente(cliente);
		
		return "redirect:/Vistas/ListaClientes";
	}
	
	@GetMapping("/EditarCliente/{id}")
	private String EditarCliente(@PathVariable("id") Integer idcliente,Model modelo) {
		
		ClassClientes cliente = iclientesservicio.BuscarPorId(idcliente);
		
		modelo.addAttribute("cliente", cliente);
		
		return "/Vistas/RegistrarClientes";
	}
	
	@GetMapping("/EliminarCliente/{id}")
	private String EliminarCliente(@PathVariable("id") Integer idcliente,Model modelo) {
		
		iclientesservicio.EliminarCliente(idcliente);
		
		List<ClassClientes> listaclientes = iclientesservicio.ListarClientes();
		
		modelo.addAttribute("listaclientes", listaclientes);
		
		return "redirect:/Vistas/ListaClientes";
	}
}
