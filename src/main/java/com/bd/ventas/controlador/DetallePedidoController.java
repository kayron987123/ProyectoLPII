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
import com.bd.ventas.modelo.ClassDetallePedido;
import com.bd.ventas.modelo.ClassPedido;
import com.bd.ventas.modelo.ClassProducto;
import com.bd.ventas.servicios.IClientesServicio;
import com.bd.ventas.servicios.IDetallePedidoServicio;
import com.bd.ventas.servicios.IPedidoServicio;
import com.bd.ventas.servicios.IProductoServicio;

@Controller
@RequestMapping("/Vistas")
public class DetallePedidoController {

	@Autowired
	private IDetallePedidoServicio idetallepedidoservicio;
	
	@Autowired
	private IPedidoServicio ipedidoservicio;
	
	@Autowired
	private IProductoServicio iproductoservicio;
	
	@Autowired
	private IClientesServicio iclientesservicio;
	
	@GetMapping("/ListaDetallePedido")
	private String ListarDetallePedidos(Model modelo) {
		
		List<ClassDetallePedido> listadetalles = idetallepedidoservicio.ListarDetallePedido();
		
		modelo.addAttribute("listadetalles", listadetalles);
		
		return "/Vistas/ListaDetallePedido";
	}
	
	@GetMapping("/RegistrarDetallePedido")
	private String RegistrarDetallePedido(Model modelo) {
		
		ClassDetallePedido detallepedido = new ClassDetallePedido();
		
		List<ClassPedido> listapedido = ipedidoservicio.ListarPedidos();
		List<ClassProducto> listaproducto = iproductoservicio.ListarProducto();
		List<ClassClientes> listacliente = iclientesservicio.ListarClientes();
		
		modelo.addAttribute("listapedido", listapedido);
		modelo.addAttribute("listaproducto", listaproducto);
		modelo.addAttribute("listacliente", listacliente);
		modelo.addAttribute("detallepedido", detallepedido);
		
		return "/Vistas/RegistrarDetallePedido";
	}
	
	@PostMapping("/GuardarDetallePedido")
	private String GuardarDetallePedido(@ModelAttribute ClassDetallePedido iddetalle,Model modelo) {
		
		idetallepedidoservicio.RegistrarDetallePedido(iddetalle);
		
		return "redirect:/Vistas/ListaDetallePedido";
	}
	
	
	@GetMapping("/EditarDetallePedido/{id}")
	private String EditarDetallePedido(@PathVariable("id") Integer iddetalle,Model modelo ) {
		
		ClassDetallePedido detallepedido = idetallepedidoservicio.BuscarPorId(iddetalle);
		
		List<ClassPedido> listapedido = ipedidoservicio.ListarPedidos();
		List<ClassProducto> listaproducto = iproductoservicio.ListarProducto();
		List<ClassClientes> listacliente = iclientesservicio.ListarClientes();
		
		modelo.addAttribute("listapedido", listapedido);
		modelo.addAttribute("listaproducto", listaproducto);
		modelo.addAttribute("listacliente", listacliente);
		
		modelo.addAttribute("detallepedido", detallepedido);
		
		return "/Vistas/RegistrarDetallePedido";
	}
	
	@GetMapping("EliminarDetallePedido/{id}")
	private String EliminarDetallePedido(@PathVariable("id") Integer iddetalle,Model modelo) {
		
		idetallepedidoservicio.EliminarDetallePedido(iddetalle);
		
		List<ClassDetallePedido> detallepedido = idetallepedidoservicio.ListarDetallePedido();
		
		modelo.addAttribute("detallepedido", detallepedido);
		
		return "redirect:/Vistas/ListaDetallePedido";
	}	
}
