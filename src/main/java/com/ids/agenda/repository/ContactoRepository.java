package com.ids.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ids.agenda.entity.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {

	@Query("SELECT con FROM Contacto con WHERE con.nombre_contacto=(:nombre_contacto)")
    Contacto findName(@Param("nombre_contacto") String contactoNombre);
	
}
