package com.unifacisa.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.livraria.entity.Autor;
import com.unifacisa.livraria.entity.Categoria;
import com.unifacisa.livraria.repository.AutorRepository;
import com.unifacisa.livraria.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

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
        // Salva a categoria, e o relacionamento é gerido pelo JPA
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}