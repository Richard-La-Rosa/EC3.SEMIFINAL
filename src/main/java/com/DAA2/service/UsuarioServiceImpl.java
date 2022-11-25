package com.DAA2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAA2.model.Usuario;
import com.DAA2.repository.IUsuarioRepository;


@Service
public class UsuarioServiceImpl  implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findById(Integer id) {
		
		return usuarioRepository.findById(id);
	}
		

}
