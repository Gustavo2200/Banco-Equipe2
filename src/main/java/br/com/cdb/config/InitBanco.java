package br.com.cdb.config;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cdb.dao.ClienteDao;
import br.com.cdb.dao.GeradorBanco;
import br.com.cdb.dao.impl.ClienteDaoImpl;

@Configuration
public class InitBanco {

	public void iniciarTabelas() throws SQLException {
		
		GeradorBanco.gerarTabela();
	}
	
	
	
}
