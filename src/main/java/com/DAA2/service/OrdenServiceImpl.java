package com.DAA2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAA2.model.Orden;
import com.DAA2.repository.IOrdenRepository;

@Service
public class OrdenServiceImpl implements IOrdenService{
	
	@Autowired
	private IOrdenRepository ordenRepository;
	
	@Override
	public Orden save(Orden orden) {
		
		return ordenRepository.save(orden);
	}

}
