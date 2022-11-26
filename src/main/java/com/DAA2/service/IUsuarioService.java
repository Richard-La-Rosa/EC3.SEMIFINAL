package com.DAA2.service;

import java.util.Optional;

import com.DAA2.model.Usuario;

public interface IUsuarioService {
	Optional<Usuario> findById(Integer id);
	Usuario save(Usuario usuario);

}
