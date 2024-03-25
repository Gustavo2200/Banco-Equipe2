package br.com.cdb;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainSpring {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(MainSpring.class, args);

	}

}