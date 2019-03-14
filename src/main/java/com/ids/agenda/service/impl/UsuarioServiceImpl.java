package com.ids.agenda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ids.agenda.entity.Usuario;
import com.ids.agenda.repository.UsuarioRepository;
import com.ids.agenda.service.UsuarioService;

/**
* @author Jose Argueta
*
*/
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void setUsuarioRepository(UsuarioRepository usuarioRepository ) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> consultaUsuario() {
		List<Usuario> usuario = usuarioRepository.findAll();
		return usuario;
	}
	
	public Usuario consultaNombreUsuario(String usuarioNombre) {
		Usuario nameUsu = usuarioRepository.findName(usuarioNombre);
		  return nameUsu;
	}
	
	public Usuario consultaUsuario(Long usuarioId) {
		  Optional<Usuario> optUsua = usuarioRepository.findById(usuarioId);
		  return optUsua.get();
	}

	public void guardaUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void borraUsuario(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);	
	}

	public void actualizaUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
