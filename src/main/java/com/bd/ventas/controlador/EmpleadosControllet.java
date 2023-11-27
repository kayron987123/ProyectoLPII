package com.bd.ventas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bd.ventas.modelo.ClassEmpleado;
import com.bd.ventas.servicios.IEmpleadoServicio;

@Controller
@RequestMapping("/Vistas")
public class EmpleadosControllet {
	
	@Autowired
	private IEmpleadoServicio iempleadoservicio;
	
	
	@RequestMapping("/LoginEmpleado")
    public String mostrarFormularioLogin() {
        return "/Vistas/LoginEmpleado";
    }
	
	@PostMapping("/VerificarCredenciales")
	public String verificarCredenciales(@RequestParam("username") String username, @RequestParam("contrasena") String contrasena,Model modelo) {
		
		ClassEmpleado empleado = iempleadoservicio.verificarCredenciales(username, contrasena);
		
		if(empleado != null) {
			return "redirect:/Vistas/ListaProductos";
		}else {
			modelo.addAttribute("error", "Credenciales Incorrectas");
			return "/Vistas/LoginEmpleado";
		}
		
	}
}
