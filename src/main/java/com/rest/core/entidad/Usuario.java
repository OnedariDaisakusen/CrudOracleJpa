package com.rest.core.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BAH_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID_USER;
	
	@Column(name = "USERNAME")
	private String USERNAME;
	
	@Column(name = "PASSWORD")
	private String PASSWORD;
	
	@Column(name = "EMAIL")
	private String EMAIL;
	
	@Column(name = "USUARIO")
	private String NOMBRE_USUARIO;

	public int getID_USER() {
		return ID_USER;
	}

	public void setID_USER(int iD_USER) {
		ID_USER = iD_USER;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getNOMBRE_USUARIO() {
		return NOMBRE_USUARIO;
	}

	public void setNOMBRE_USUARIO(String nOMBRE_USUARIO) {
		NOMBRE_USUARIO = nOMBRE_USUARIO;
	}
	
	
	
}
