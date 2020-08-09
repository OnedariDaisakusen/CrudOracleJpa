package com.rest.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.core.entidad.Usuario;
import com.rest.core.service.UsuarioService;

@RestController
@RequestMapping(value = "/rest")
public class UsuarioController {

	@Autowired
	UsuarioService service;
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")
	public List<Usuario> lista(){
		return service.lista(1);
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST, produces = "application/json")
	public Usuario registrar(@RequestBody Usuario usuario) {
		usuario = service.registrar(usuario);
		return usuario;
	}
	
}
