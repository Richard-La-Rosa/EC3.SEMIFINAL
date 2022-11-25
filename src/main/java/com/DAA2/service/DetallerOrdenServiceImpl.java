package com.DAA2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAA2.model.DetalleOrden;
import com.DAA2.repository.IDetalleOrdenRepository;

@Service
public class DetallerOrdenServiceImpl implements IDetallerOrdenService{
	@Autowired
	private IDetalleOrdenRepository detalleOrdenRepository;
	
	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {


		return detalleOrdenRepository.save(detalleOrden);
	}

}
