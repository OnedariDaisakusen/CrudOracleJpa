package com.rest.core.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Usuario {

	private int idUser;
	private String nombre;
	private String username;
	private String password;
	private String cargo;
	private String email;
	private String cargoUsuario;
	private int flgActivo;
	private int idDddi;
	private String nombreDdi;
	private String codDdi;
	private String control;
	private String flgReporteStock;
	private String codigo_respuesta;
	private String mensaje_respuesta;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCargoUsuario() {
		return cargoUsuario;
	}
	public void setCargoUsuario(String cargoUsuario) {
		this.cargoUsuario = cargoUsuario;
	}
	public int getFlgActivo() {
		return flgActivo;
	}
	public void setFlgActivo(int flgActivo) {
		this.flgActivo = flgActivo;
	}
	public String getNombreDdi() {
		return nombreDdi;
	}
	public void setNombreDdi(String nombreDdi) {
		this.nombreDdi = nombreDdi;
	}
	public String getControl() {
		return control;
	}
	public void setControl(String control) {
		this.control = control;
	}
	public String getFlgReporteStock() {
		return flgReporteStock;
	}
	public void setFlgReporteStock(String flgReporteStock) {
		this.flgReporteStock = flgReporteStock;
	}
	public String getCodigo_respuesta() {
		return codigo_respuesta;
	}
	public void setCodigo_respuesta(String codigo_respuesta) {
		this.codigo_respuesta = codigo_respuesta;
	}
	public String getMensaje_respuesta() {
		return mensaje_respuesta;
	}
	public void setMensaje_respuesta(String mensaje_respuesta) {
		this.mensaje_respuesta = mensaje_respuesta;
	}
	public int getIdDddi() {
		return idDddi;
	}
	public void setIdDddi(int idDddi) {
		this.idDddi = idDddi;
	}
	public String getCodDdi() {
		return codDdi;
	}
	public void setCodDdi(String codDdi) {
		this.codDdi = codDdi;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
		
}
