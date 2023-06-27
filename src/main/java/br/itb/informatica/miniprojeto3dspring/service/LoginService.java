package br.itb.informatica.miniprojeto3dspring.service;
import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.informatica.miniprojeto3dspring.model.Login;
import br.itb.informatica.miniprojeto3dspring.model.LoginRepository;
import jakarta.transaction.Transactional;

@Service
public class LoginService {
	
	//Criação do objeto repository
	final LoginRepository loginRepository;
	
	//Criar construtor para injeção de dependência
	public LoginService(LoginRepository _loginRepository) {
		this.loginRepository = _loginRepository;
		
	}

	// Método de inserção de dados
	// Rota POST
	@Transactional
	public Login save(Login login) {
		return loginRepository.save(login);
	}
	
	//Método de pesquisa de dados
	//Rota GET select * from produto
	public List<Login> findAll(){
		List<Login> listaLogin = loginRepository.findAll();
		return listaLogin;
	}

	// buscar por nome
    public String findOneLogin(String usuario, String senha) {
        return loginRepository.findOneLogin(usuario, senha);
    }

}
