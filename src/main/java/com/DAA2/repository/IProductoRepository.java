package com.DAA2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DAA2.model.Producto;


@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
	
	

}
