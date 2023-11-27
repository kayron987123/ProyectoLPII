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

import com.bd.ventas.modelo.ClassEmpleado;
import com.bd.ventas.modelo.ClassPedido;
import com.bd.ventas.servicios.IEmpleadoServicio;
import com.bd.ventas.servicios.IPedidoServicio;

@Controller
@RequestMapping("/Vistas")
public class PedidosController {
	
	@Autowired
	private IPedidoServicio ipedidoservicio;
	
	@Autowired
	private IEmpleadoServicio iempleadoservicio;
	
	@GetMapping("/ListaPedidos")
	private String ListarPedidos(Model modelo) {
		
		List<ClassPedido> listapedidos = ipedidoservicio.ListarPedidos();
		
		modelo.addAttribute("listapedidos", listapedidos);
		
		return "/Vistas/ListaPedidos";
	}
	
	@GetMapping("/RegistrarPedido")
	private String RegistrarPedido(Model modelo) {
		
		ClassPedido pedido = new ClassPedido();
		
		List<ClassEmpleado> listaempleado=iempleadoservicio.ListarEmpleado();
		
		modelo.addAttribute("listaempleado", listaempleado);
		
		modelo.addAttribute("pedido", pedido);
		
		return "/Vistas/RegistrarPedidos";
	}
	
	@PostMapping("/GuardarPedido")
	private String GuardarPedido(@ModelAttribute ClassPedido pedido,Model modelo) {
		
		ipedidoservicio.RegistrarPedido(pedido);
		
		return "redirect:/Vistas/ListaPedidos";
	}
	
	@GetMapping("/EditarPedido/{id}")
	private String EditarPedido(@PathVariable("id") Integer idpedido,Model modelo) {
		
		ClassPedido pedido = ipedidoservicio.BuscarPorId(idpedido);
		
		List<ClassEmpleado> listaempleado=iempleadoservicio.ListarEmpleado();
		
		modelo.addAttribute("listaempleado", listaempleado);
		modelo.addAttribute("pedido",pedido);
				
		return "/Vistas/RegistrarPedidos";
	}
	
	@GetMapping("EliminarPedido/{id}")
	private String EliminarPedido(@PathVariable("id") Integer idpedido,Model modelo) {
		
		ipedidoservicio.EliminarPedido(idpedido);
		
		List<ClassPedido> listapedidos = ipedidoservicio.ListarPedidos();
		
		modelo.addAttribute("listapedidos", listapedidos);
		
		return "redirect:/Vistas/ListaPedidos";	
	}
}
