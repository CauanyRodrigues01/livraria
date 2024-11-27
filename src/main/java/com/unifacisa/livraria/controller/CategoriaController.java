package com.unifacisa.livraria.controller;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

  @Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listar() {
        return categoriaService.listar();
	}
	
	@PostMapping
	public Categoria salvar(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
  }

  @DeleteMapping("/{id}")    
  public void deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
    }

}
