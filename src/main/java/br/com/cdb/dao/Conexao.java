package br.com.cdb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

public static Connection abrir() throws SQLException {
	Connection con = DriverManager.getConnection("jdbc:h2:mem:banco", "sa", "");
	return con;
}

}
