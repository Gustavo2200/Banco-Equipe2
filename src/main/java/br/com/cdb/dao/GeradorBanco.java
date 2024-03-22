package br.com.cdb.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GeradorBanco {

	public static void gerarTabela() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS TB_CLIENTE(\r\n"
				+ "NM_CLIENTE VARCHAR(255),\r\n"
				+ "DT_NASCIMENTO DATE,\r\n"
				+ "NR_CPF VARCHAR(11),\r\n"
				+ "DS_EMAIL VARCHAR(100),\r\n"
				+ "DS_SENHA VARCHAR(100),\r\n"
				+ "NR_ID_CLIENTE INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "PRIMARY KEY(NR_ID_CLIENTE)\r\n"
				+ ");\r\n"
				+ "\r\n"
				+ "CREATE TABLE IF NOT EXISTS TB_CONTA(\r\n"
				+ "DS_SENHA VARCHAR(100),\r\n"
				+ "VL_SALDO DECIMAL(30,2),\r\n"
				+ "NR_CONTA INT,\r\n"
				+ "NR_AGENCIA SMALLINT,\r\n"
				+ "NR_ID_CONTA INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "NR_ID_CLIENTE INT,\r\n"
				+ "PRIMARY KEY(NR_ID_CONTA),\r\n"
				+ "FOREIGN KEY(NR_ID_CLIENTE)REFERENCES TB_CLIENTE(NR_ID_CLIENTE)\r\n"
				+ ");\r\n"
				+ "\r\n"
				+ "CREATE TABLE IF NOT EXISTS TB_TRANSFERENCIA(\r\n"
				+ "NR_CONTA_DESTINO INT NOT NULL,\r\n"
				+ "NR_CONTA_ORIGEM INT NOT NULL,\r\n"
				+ "VL_TRANSFERENCIA DECIMAL(30,2),\r\n"
				+ "NR_ID_TRANSFERENCIA INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "NR_TIPO SMALLINT,\r\n"
				+ "PRIMARY KEY(NR_ID_TRANSFERENCIA),\r\n"
				+ "FOREIGN KEY(NR_CONTA_DESTINO)REFERENCES TB_CONTA(NR_ID_CONTA),\r\n"
				+ "FOREIGN KEY(NR_CONTA_ORIGEM)REFERENCES TB_CONTA(NR_ID_CONTA)\r\n"
				+ ");\r\n"
				+ "";

		Connection con = Conexao.abrir();
		Statement st = con.createStatement();
		st.execute(sql);
		st.close();
		con.close();

	}
}
