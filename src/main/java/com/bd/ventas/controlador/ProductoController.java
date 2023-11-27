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

import com.bd.ventas.modelo.ClassCategoria;
import com.bd.ventas.modelo.ClassMarca;
import com.bd.ventas.modelo.ClassProducto;
import com.bd.ventas.servicios.ICategoriaServicio;
import com.bd.ventas.servicios.IMarcaServicio;
import com.bd.ventas.servicios.IProductoServicio;

@Controller
@RequestMapping("/Vistas")
public class ProductoController {
	
	@Autowired
	private IProductoServicio iproductoservicio;
	
	@Autowired
	private ICategoriaServicio icategoriaservicio;
	
	@Autowired
	private IMarcaServicio imarcaservicio;
	
	@GetMapping("/ListaProductos")
	private String ListarProductos(Model modelo) {
		
		
		List<ClassProducto> listaprod = iproductoservicio.ListarProducto();
		
		modelo.addAttribute("listaprod", listaprod);
		
		return "/Vistas/ListaProductos";
	}
	
	@GetMapping("/RegistrarProducto")
	private String RegistrarProductos(Model modelo) {
		
		ClassProducto producto = new ClassProducto();
		
		List<ClassMarca> listamarca = imarcaservicio.ListarMarcas();
		List<ClassCategoria> listacategoria = icategoriaservicio.ListarCategoria();
		
		modelo.addAttribute("producto", producto);
		modelo.addAttribute("listacategoria", listacategoria);
		modelo.addAttribute("listamarca", listamarca);
		
		return "/Vistas/RegistrarProducto";
	}
	
	@PostMapping("/GuardarProducto")
	private String GuardarProducto(@ModelAttribute ClassProducto producto,Model modelo) {
		
		iproductoservicio.RegistrarProducto(producto);
				
		return "redirect:/Vistas/ListaProductos";
	}
	
	@GetMapping("/EditarProducto/{id}")
	private String EditarProducto(@PathVariable("id") Integer idproducto,Model modelo) {
		
		ClassProducto producto = iproductoservicio.BuscarPorId(idproducto);
		
		List<ClassMarca> listamarca = imarcaservicio.ListarMarcas();
		List<ClassCategoria> listacategoria = icategoriaservicio.ListarCategoria();
		
		modelo.addAttribute("producto", producto);
		
		modelo.addAttribute("listacategoria", listacategoria);
		modelo.addAttribute("listamarca", listamarca);
		
		
		return "/Vistas/RegistrarProducto";
	}
	
	@GetMapping("/EliminarProducto/{id}")
	private String EliminarProducto(@PathVariable("id") Integer idproducto, Model modelo) {
		iproductoservicio.EliminarProducto(idproducto);
		
		List<ClassProducto> listaprod = iproductoservicio.ListarProducto();
		
		modelo.addAttribute("listaprod", listaprod);
		
		return "redirect:/Vistas/ListaProductos";
	}

}
