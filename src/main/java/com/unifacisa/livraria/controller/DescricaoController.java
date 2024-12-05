package com.unifacisa.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unifacisa.livraria.entity.Descricao;
import com.unifacisa.livraria.service.DescricaoService;

@RestController
@RequestMapping("/descricoes")
public class DescricaoController {

    @Autowired
    private DescricaoService descricaoService;

    @PostMapping
    public Descricao salvar(@RequestBody Descricao descricao) {
        return descricaoService.salvar(descricao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Descricao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.of(descricaoService.buscarPorId(id));
    }
}
