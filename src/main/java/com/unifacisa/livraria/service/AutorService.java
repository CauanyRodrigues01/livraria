package com.unifacisa.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.livraria.entity.Autor;
import com.unifacisa.livraria.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	 public List<Autor> listarTodos() {
	        return autorRepository.findAll();
	    }

	    public Autor salvar(Autor autor) {
	        return autorRepository.save(autor);
	    }

	    
	    public void deletar(Long id) {
	    	if(autorRepository.existsById(id)) {
	    		autorRepository.deleteById(id);
	    	} else {
	    		throw new RuntimeException("Autor não encontrado com ID" + id);
	    	}
	    }
}
