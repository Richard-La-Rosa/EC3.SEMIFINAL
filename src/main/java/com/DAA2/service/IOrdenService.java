package com.DAA2.service;

import java.util.List;


import com.DAA2.model.Orden;


public interface IOrdenService {
	List <Orden> findAll();
	Orden save(Orden orden);
	String generarNumeroOrden();
	

}
