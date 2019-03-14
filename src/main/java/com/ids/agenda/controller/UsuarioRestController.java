package com.ids.agenda.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ids.agenda.entity.Usuario;
import com.ids.agenda.service.UsuarioService;

/**
* @author Jose Argueta
*
*/
@RestController
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	public void setUsuarioRepository(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/api/usuarios")
	public List<Usuario> consultaUsuario() {
		List<Usuario> usuarios = usuarioService.consultaUsuario();
		return usuarios;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/api/usuarios/{usuarioId}")
	public Usuario consultaUsuario(@PathVariable(name="usuarioId")Long usuarioId, HttpServletResponse res) {
		Usuario usua = usuarioService.consultaUsuario(usuarioId);
		if(usua == null) {
			System.out.println("Este usuario no existe!!!");
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		    return null;
		}
		else{
			System.out.println("Si existe!!");
			return usuarioService.consultaUsuario(usuarioId);
			
		}
		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/api/usuarios/buscar/{usuarioNombre}")
	public Usuario consultaNombreUsuario(@PathVariable(name="usuarioNombre")String usuarioNombre, HttpServletResponse res) {
		Usuario usua = usuarioService.consultaNombreUsuario(usuarioNombre);
		if(usua == null) {
			System.out.println("Este contacto no existe!!!");
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		    return null;
		}
		else{
			System.out.println("Si existe!!");
			return usuarioService.consultaNombreUsuario(usuarioNombre);
			
		}
		
		
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/api/usuarios")
	public void guardaUsuario(@RequestBody Usuario usuario){
		usuarioService.guardaUsuario(usuario);
		System.out.println("Usuario Guardado con Exito!!");
	  
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/api/usuarios/{usuarioId}")
	public void borraUsuario(@PathVariable(name="usuarioId")Long usuarioId) {
		usuarioService.borraUsuario(usuarioId);
		System.out.println("Usuario Eliminado con Exito!!");
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/api/usuarios/{usuarioId}")
	public void actualizaUsuario(@RequestBody Usuario usuario,
		@PathVariable(name="usuarioId")Long usuarioId){
		Usuario usua = usuarioService.consultaUsuario(usuarioId);
		if(usua != null){
			usuarioService.actualizaUsuario(usuario);
			System.out.println("Contacto Actualizado con Exito!!");
		}
	}
}
