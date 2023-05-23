package br.itb.informatica.miniprojeto3dspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.informatica.miniprojeto3dspring.model.Produto;
import br.itb.informatica.miniprojeto3dspring.model.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	
	// Criação do objeto repository
	final ProdutoRepository produtoRepository;
	
	// Criar construtor para injeção de dependência
	public ProdutoService(ProdutoRepository _produtoRepository) {
		this.produtoRepository = _produtoRepository;
	}
	
	// Método de inserção de dados
	// Rota POST INSERT
	@Transactional
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	// Método de pesquisa de dados
	// Rota GET select * from produto
	public List<Produto> findAll(){
		List<Produto> listaProdutos = produtoRepository.findAll();
		return listaProdutos;
	}
	
	
	
	
	
	
	
	
}
