package com.unifacisa.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifacisa.livraria.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
