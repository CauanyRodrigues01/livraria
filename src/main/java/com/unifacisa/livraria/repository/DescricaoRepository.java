package com.unifacisa.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unifacisa.livraria.entity.Descricao;

@Repository
public interface DescricaoRepository extends JpaRepository<Descricao, Long> {
}
