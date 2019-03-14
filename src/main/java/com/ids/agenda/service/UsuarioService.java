package com.ids.agenda.service;

import java.util.List;

import com.ids.agenda.entity.Usuario;

/**
* @author Jose Argueta
*
*/
public interface UsuarioService {
	
	public List<Usuario> consultaUsuario();
	
	public Usuario consultaUsuario(Long usuarioId);
	
	public Usuario consultaNombreUsuario(String usuarioNombre);
	
	public void guardaUsuario(Usuario usuario);
	
	public void borraUsuario(Long usuarioId);
	
	public void actualizaUsuario(Usuario usuario);
	
}
