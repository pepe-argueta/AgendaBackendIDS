package com.ids.agenda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ids.agenda.entity.Contacto;
import com.ids.agenda.repository.ContactoRepository;
import com.ids.agenda.service.ContactoService;

import java.util.List;
import java.util.Optional;

/**
* @author Jose Argueta
*
*/
@Service
public class ContactoServiceImpl implements ContactoService {

	@Autowired
	private ContactoRepository contactoRepository;
	
	public void setContactoRepository(ContactoRepository contactoRepository ) {
		this.contactoRepository = contactoRepository;
	}

	public List<Contacto> consultaContacto() {
		List<Contacto> contacto = contactoRepository.findAll();
		return contacto;
	}
	
	public Contacto consultaNombreContacto(String contactoNombre) {
		  Contacto nameConta = contactoRepository.findName(contactoNombre);
		  return nameConta;
	}
	
	public Contacto consultaContacto(Long contactoId) {
		  Optional<Contacto> optConta = contactoRepository.findById(contactoId);
		  return optConta.get();
	}

	public void guardaContacto(Contacto contacto) {
		contactoRepository.save(contacto);
	}

	public void borraContacto(Long contactoId) {
		contactoRepository.deleteById(contactoId);	
	}

	public void actualizaContacto(Contacto contacto) {
		contactoRepository.save(contacto);
	}
	
}
