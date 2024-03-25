package br.com.cdb.config;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cdb.dao.ClienteDao;
import br.com.cdb.dao.impl.ClienteDaoImpl;
import jakarta.annotation.PostConstruct;

@Configuration
public class InitBanco {

	@PostConstruct
	public void iniciarTabelas() throws SQLException {
		
		GeradorBanco.gerarTabela();
	}
	
}
