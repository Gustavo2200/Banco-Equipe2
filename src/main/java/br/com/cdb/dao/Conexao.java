package br.com.cdb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection abrir() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://monorail.proxy.rlwy.net:37657/railway?allowMultiQueries=true", "root",
				"urnWCvjSjEjvAGiIXKxhyPUapmjsCnMT");
		return con;
	}

}
