package com.ids.agenda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @author Jose Argueta
*
*/
@Entity
@Table(name="CONTACTO")
public class Contacto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOMBRE_CONTACTO")
	private String nombre_contacto;
	
	@Column(name="TELEFONO_PERSONAL")
	private String telefono_personal;
	
	@Column(name="TELEFONO_OFICINA")
	private String telefono_oficina;
	
	@Column(name="CORREO_PERSONAL")
	private String correo_personal;
	
	@Column(name="CORREO_OFICINA")
	private String correo_oficina;
	
	@Column(name="FECHA_NACIMIENTO")
	private String fecha_nacimiento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_contacto() {
		return nombre_contacto;
	}

	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}

	public String getTelefono_personal() {
		return telefono_personal;
	}

	public void setTelefono_personal(String telefono_personal) {
		this.telefono_personal = telefono_personal;
	}

	public String getTelefono_oficina() {
		return telefono_oficina;
	}

	public void setTelefono_oficina(String telefono_oficina) {
		this.telefono_oficina = telefono_oficina;
	}

	public String getCorreo_personal() {
		return correo_personal;
	}

	public void setCorreo_personal(String correo_personal) {
		this.correo_personal = correo_personal;
	}

	public String getCorreo_oficina() {
		return correo_oficina;
	}

	public void setCorreo_oficina(String correo_oficina) {
		this.correo_oficina = correo_oficina;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
}
