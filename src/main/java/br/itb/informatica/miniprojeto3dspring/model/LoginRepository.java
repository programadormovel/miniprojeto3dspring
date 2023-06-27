package br.itb.informatica.miniprojeto3dspring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	@Query("select id, usuario, senha from login where usuario=:usuario and senha=:senha")
	String findOneLogin(String usuario, String senha);

}
