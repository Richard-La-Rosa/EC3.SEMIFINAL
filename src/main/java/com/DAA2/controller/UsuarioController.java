package com.DAA2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DAA2.model.Usuario;
import com.DAA2.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final Logger logger=LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	// /usuario/registro
	@GetMapping("/registro")
	public String create() {
		return "usuario/registro";
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		logger.info("Usuario registro:{}",usuario);
		usuario.setTipo("USER");
		usuarioService.save(usuario); 
		
		return "redirect:/";
	}

}
