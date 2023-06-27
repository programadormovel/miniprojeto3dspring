package br.itb.informatica.miniprojeto3dspring.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.informatica.miniprojeto3dspring.model.Produto;
import br.itb.informatica.miniprojeto3dspring.service.ProdutoService;

@RestController
@CrossOrigin(origins="*", maxAge=3600, allowCredentials="false")
@RequestMapping("/produto")
public class ProdutoController {

		// Criar objeto de serviço
		final ProdutoService produtoService;
		
		// Construtor de injeção de dependência
		public ProdutoController(ProdutoService produtoService) {
			super();
			this.produtoService = produtoService;
		}
		
		// Rota POST INSERT INTO PRODUTO
		@PostMapping
		public ResponseEntity<Object> saveProduto(Produto produto){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(produtoService.save(produto));
		}
		
		// Rota GET Select * from produto
		@GetMapping
		public ResponseEntity<List<Produto>> getAllProdutos(){
			return ResponseEntity.status(HttpStatus.OK)
					.body(produtoService.findAll());
		}
		
		
		
		
		
		
		
}
