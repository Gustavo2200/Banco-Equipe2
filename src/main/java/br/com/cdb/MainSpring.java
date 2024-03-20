package br.com.cdb;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cdb.dao.Conexao;

@SpringBootApplication
public class MainSpring {

public static void main(String[] args) throws SQLException {
SpringApplication.run(MainSpring.class, args);

	}

}