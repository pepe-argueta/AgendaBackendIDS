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

import com.ids.agenda.entity.Contacto;
import com.ids.agenda.service.ContactoService;

/**
* @author Jose Argueta
*
*/
@RestController
public class ContactoRestController {
	
	@Autowired
	private ContactoService contactoService;
	
	public void setContactoRepository(ContactoService contactoService) {
		this.contactoService = contactoService;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/api/contactos")
	public List<Contacto> consultaContacto() {
		List<Contacto> contactos = contactoService.consultaContacto();
		return contactos;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/api/contactos/{contactoId}")
	public Contacto consultaContacto(@PathVariable(name="contactoId")Long contactoId, HttpServletResponse res) {
		Contacto contac = contactoService.consultaContacto(contactoId);
		if(contac == null) {
			System.out.println("Este contacto no existe!!!");
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		    return null;
		}
		else{
			System.out.println("Si existe!!");
			return contactoService.consultaContacto(contactoId);
			
		}
		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/api/contactos/buscar/{contactoNombre}")
	public Contacto consultaNombreContacto(@PathVariable(name="contactoNombre")String contactoNombre, HttpServletResponse res) {
		Contacto contac = contactoService.consultaNombreContacto(contactoNombre);
		if(contac == null) {
			System.out.println("Este contacto no existe!!!");
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		    return null;
		}
		else{
			System.out.println("Si existe!!");
			return contactoService.consultaNombreContacto(contactoNombre);
			
		}
		
		
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/api/contactos")
	public void guardaContacto(@RequestBody Contacto contacto){
		contactoService.guardaContacto(contacto);
		System.out.println("Contacto Guardado con Exito!!");
	  
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/api/contactos/{contactoId}")
	public void borrarContacto(@PathVariable(name="contactoId")Long contactoId) {
		contactoService.borraContacto(contactoId);
		System.out.println("Contacto Eliminado con Exito!!");
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/api/contactos/{contactoId}")
	public void actualizaContacto(@RequestBody Contacto contacto,
		@PathVariable(name="contactoId")Long contactoId){
		Contacto contac = contactoService.consultaContacto(contactoId);
		if(contac != null){
			contactoService.actualizaContacto(contacto);
			System.out.println("Contacto Actualizado con Exito!!");
		}
	}
	
}
