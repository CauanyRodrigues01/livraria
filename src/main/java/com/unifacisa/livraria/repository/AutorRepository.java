package com.unifacisa.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.livraria.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
