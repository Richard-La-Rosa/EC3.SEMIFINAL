package com.DAA2.controller;


import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.DAA2.model.Producto;
import com.DAA2.model.Usuario;
import com.DAA2.service.ProductoService;
import com.DAA2.service.UploadFileService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private UploadFileService upload;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos",productoService.findAll());
		return "productos/show";
	}
	
	
	@GetMapping("/create")
	public String create() {
		
		return "productos/create";
	}
	
	@PostMapping("/save")
	public String save(Producto producto,@RequestParam("img") MultipartFile file) throws IOException {
		LOGGER.info("Este es el objeto producto {}",producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "");
		producto.setUsuario(u);
		
		//imagen
		if (producto.getId()== null) { // cuando se crea un producto
			String nombreImagen= upload.saveImage(file);
            producto.setImagen(nombreImagen);		
		}else {
		
		}
		
		
		productoService.save(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto producto = new Producto();
		Optional<Producto> optionalProducto =productoService.get(id);
		producto=optionalProducto.get();
		
		LOGGER.info("Producto buscado : {}",producto);
		model.addAttribute("producto",producto);
		return "productos/edit";
	}
	
	@PostMapping("/update")
	public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
		Producto p= new Producto();
		p=productoService.get(producto.getId()).get();
		
		if (file.isEmpty()) {
			
			producto.setImagen(p.getImagen());
		}else {// cuando se edita tbn la imagen
			
			
			//eliminar cuando no sea la imagen por defecto
			if(!p.getImagen().equals("MI LOGO.jpg")) {
				upload.deleteImage(p.getImagen());
			}
			
			String nombreImagen = upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}
		
		producto.setUsuario(p.getUsuario());
		productoService.update(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		Producto p = new Producto();
		p=productoService.get(id).get();
		
		//eliminar cuando no sea la imagen por defecto
		if(!p.getImagen().equals("MI LOGO.jpg")) {
			upload.deleteImage(p.getImagen());
		}
		
		
		productoService.delete(id);
		return "redirect:/productos";
	}

}
