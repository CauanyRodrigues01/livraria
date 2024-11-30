package com.unifacisa.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.livraria.entity.Autor;
import com.unifacisa.livraria.entity.Categoria;
import com.unifacisa.livraria.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	public Categoria salvar(Categoria categoria) {
	    // Para cada autor associado à categoria, sincronize o relacionamento
	    if (categoria.getAutores() != null) {
	        for (Autor autor : categoria.getAutores()) {
	            autor.getCategorias().add(categoria); // Atualiza o lado do Autor
	        }
	    }
	    return categoriaRepository.save(categoria); // Salva no banco
	}

	public void deletar(Long id) {
        	categoriaRepository.deleteById(id);
    	}
}
