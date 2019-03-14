package com.ids.agenda.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ids.agenda.entity.Usuario;

/**
* @author Jose Argueta
*
*/
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("SELECT c from Usuario c WHERE lower(c.nombre_usuario) like :nombre_usuario")
    Usuario findName(@Param("nombre_usuario") String usuarioNombre);
}
