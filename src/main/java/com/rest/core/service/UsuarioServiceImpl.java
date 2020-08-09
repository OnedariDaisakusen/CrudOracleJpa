package com.rest.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.core.entidad.Usuario;
import com.rest.core.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public List<Usuario> lista(int id) {
		// TODO Auto-generated method stub
		return repository.lista(id);
	}

	@Override
	public Usuario registrar(Usuario usuario) {
		// TODO Auto-generated method stub
		return repository.registrar(usuario);
	}

}
