package com.unifacisa.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifacisa.livraria.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
