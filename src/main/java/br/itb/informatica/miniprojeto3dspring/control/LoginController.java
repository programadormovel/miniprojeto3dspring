package br.itb.informatica.miniprojeto3dspring.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.itb.informatica.miniprojeto3dspring.model.Login;
import br.itb.informatica.miniprojeto3dspring.service.LoginService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/login")
public class LoginController {

	// Criar objeto de serviço
	final LoginService loginService;

	// Construtor de injeção de dependência
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}

	// Rota POST INSERT INTO PRODUTO
	@PostMapping
	public ResponseEntity<Object> saveLogin(Login login) {
		return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(login));
	}

	// Rota GET Select * from produto
	@GetMapping
	public ResponseEntity<List<Login>> getAllLogin() {
		return ResponseEntity.status(HttpStatus.OK).body(loginService.findAll());
	}

	// GET

//		        @PostMapping("/logar")

	// @ResponseBody

	@GetMapping("/logar")
	@ResponseBody
	public ResponseEntity<Object> logar(@RequestParam(name = "usuario") String usuario, @RequestParam String senha) {

		System.out.println("dados: " + usuario + "  " + senha);

		// adm.setNome(admService.findAdm(nome, senha));

		String teste = loginService.findOneLogin(usuario, senha);

		String[] parcial = teste.split(",");

		Login login = new Login(Long.parseLong(parcial[0]), parcial[1], parcial[2]);

		System.out.println(login.getUsuario());

		return ResponseEntity.status(HttpStatus.OK).body(login);

	}

}
