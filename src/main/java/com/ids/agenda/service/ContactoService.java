package com.ids.agenda.service;

import java.util.List;

import com.ids.agenda.entity.Contacto;

/**
* @author Jose Argueta
*
*/
public interface ContactoService {


	public List<Contacto> consultaContacto();
	
	public Contacto consultaContacto(Long contactoId);
	
	public Contacto consultaNombreContacto(String contactoNombre);
	
	public void guardaContacto(Contacto contacto);
	
	public void borraContacto(Long contactoId);
	
	public void actualizaContacto(Contacto contacto);
	
}
