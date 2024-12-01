package com.unifacisa.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.livraria.entity.Autor;
import com.unifacisa.livraria.entity.Categoria;
import com.unifacisa.livraria.repository.AutorRepository;
import com.unifacisa.livraria.repository.CategoriaRepository;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor salvar(Autor autor) {
        if (autor.getCategorias() != null) {
            for (Categoria categoria : autor.getCategorias()) {
                Categoria categoriaPersistida = categoriaRepository.findById(categoria.getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + categoria.getId()));
                categoriaPersistida.getAutores().add(autor); // Atualiza o lado da categoria
            }
        }
        return autorRepository.save(autor); // Salva o autor com o relacionamento sincronizado
    }


    public void deletar(Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Autor não encontrado com ID: " + id);
        }
    }
}