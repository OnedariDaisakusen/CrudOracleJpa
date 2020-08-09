package com.rest.core.service;

import java.util.List;

import com.rest.core.entidad.Usuario;

public interface UsuarioService {

	List<Usuario> lista(int id);
	
	Usuario registrar(Usuario usuario);
	
}
