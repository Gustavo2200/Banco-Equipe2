package br.com.cdb.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection abrir() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://viaduct.proxy.rlwy.net:55791/railway?allowMultiQueries=true", "root",
				"juTzPzlDCFAJdfQeDGwkCeBdGHlGoLKw");
		return con;
	}

}
