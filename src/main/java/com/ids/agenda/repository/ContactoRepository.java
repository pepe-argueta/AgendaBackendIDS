package com.ids.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ids.agenda.entity.Contacto;

/**
* @author Jose Argueta
*
*/
public interface ContactoRepository extends JpaRepository<Contacto, Long> {

	@Query("SELECT c from Contacto c WHERE lower(c.nombre_contacto) like :nombre_contacto")
    Contacto findName(@Param("nombre_contacto") String contactoNombre);
	
	@Query("SELECT co from Contacto co ORDER BY co.nombre_contacto")
    List<Contacto> findAllContacts();
	
}
