package br.com.fiap.checkpoint2.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint2.model.Produto;
import br.com.fiap.checkpoint2.repository.ProdutoRepository;
import br.com.fiap.checkpoint2.service.ProdutoService;
import dto.produto.ProdutoRequestCreate;
import dto.produto.ProdutoRequestUpdate;
import dto.produto.SearchedProduto;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<SearchedProduto> listAll() {
		List<SearchedProduto> result = 
				produtoService.list()
				.stream()
				.map(SearchedProduto::toDto)
				.collect(Collectors.toList());
		return result;
	}
	
	@PostMapping	
	public Produto create(@RequestBody ProdutoRequestCreate dto) {		
		Produto produto = new Produto();

		
		produto.setNome_prod(dto.getNome_prod());
		produto.setPreco_prod(dto.getPreco_prod());
		produto.setData_val_prod(dto.getData_val_prod());
		produto.setData_gar_prod(dto.getData_gar_prod());
		produto.setEm_est_prod(dto.getEm_est_prod());
		
		Produto result = produtoService.save(produto);
		return result;
	}

	@PutMapping
	public Produto update(@RequestBody ProdutoRequestUpdate dto) {
		
		boolean exists =
				produtoRepository.existsById(dto.getCod_prod());
		
		if (!exists) {
			throw new RuntimeException("Código do Produto não encontrado " + dto.getCod_prod());			
		}
		Produto produto = new Produto();

		produto.setCod_prod(dto.getCod_prod());
		produto.setNome_prod(dto.getNome_prod());
		produto.setData_val_prod(dto.getData_val_prod());
		produto.setData_gar_prod(dto.getData_gar_prod());
		produto.setPreco_prod(dto.getPreco_prod());
		produto.setEm_est_prod(dto.getEm_est_prod());
		
		Produto result = produtoService.save(produto);
		return result;
	}

	@DeleteMapping(value = "{cod_prod}")
	public void delete(@PathVariable Long cod_prod) {
		produtoRepository.deleteById(cod_prod);		
	}

	@GetMapping("/{cod_prod}")
	public Produto findById(@PathVariable Long cod_prod) {
		return produtoService.findById(cod_prod);
	}
}
