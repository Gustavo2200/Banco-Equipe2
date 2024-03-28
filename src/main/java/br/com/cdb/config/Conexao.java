package br.com.cdb.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection abrir() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://monorail.proxy.rlwy.net:32710/railway?allowMultiQueries=true", "root",
				"KyRSGsAWPdDmCpLYNUhTlNjwopSwvJqn");
		return con;
	}

}
