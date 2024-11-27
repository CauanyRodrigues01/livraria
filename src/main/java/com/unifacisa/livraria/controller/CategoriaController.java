package com.unifacisa.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.livraria.entity.Categoria;
import com.unifacisa.livraria.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

  @Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listar() {
        return categoriaService.listar();
	}
	
	@PostMapping
	public Categoria salvar(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
  }

  @DeleteMapping("/{id}")    
  public void deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
    }

}
