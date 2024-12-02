package com.unifacisa.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.livraria.entity.Autor;
import com.unifacisa.livraria.entity.Livro;
import com.unifacisa.livraria.repository.AutorRepository;
import com.unifacisa.livraria.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro salvar(Livro livro) {
        if (livro.getAutor() != null && livro.getAutor().getId() != null) {
            Autor autor = autorRepository.findById(livro.getAutor().getId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com ID " + livro.getAutor().getId()));
            livro.setAutor(autor);
        }
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
        } else {
            throw new RuntimeException("Livro não encontrado com ID " + id);
        }
    }
}
