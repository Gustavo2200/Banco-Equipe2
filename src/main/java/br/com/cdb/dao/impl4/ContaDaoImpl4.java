package br.com.cdb.dao.impl4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cdb.config.Conexao;
import br.com.cdb.dao.ContaDao;
import br.com.cdb.entity.Conta;
import br.com.cdb.enums.TipoPagamento;

@Repository("ContaDaoJDBC")
public class ContaDaoImpl4 implements ContaDao{

	@Override
	public List<Conta> listar()  {
	
		List<Conta> l = new ArrayList();
		
		try {
		
		Connection con = Conexao.abrir();
		

		Statement statement = con.createStatement();

		ResultSet resultado = statement.executeQuery("SELECT * FROM TB_CONTA");

		while (resultado.next()) {
			Conta c = new Conta();
			c.setId(resultado.getInt("NR_ID_CONTA"));
			c.setAgencia(resultado.getInt("NR_AGENCIA"));
			c.setNumeroConta(resultado.getInt("NR_CONTA"));
			c.setSaldo(resultado.getDouble("VL_SALDO"));
			c.setSenha(resultado.getString("DS_SENHA"));
			
			
			l.add(c);
			
		}
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
		
	}

	@Override
	public void depositar(double valor, int numeroConta)  {
		try {
			Connection con = Conexao.abrir();
			String sql = "SET @nrContaDestino = ?;\r\n"
					+ "SET @valorTransferencia = ?;\r\n"
					+ " \r\n"
					+ " \r\n"
					+ "SET @novoSaldoDestino = ((SELECT VL_SALDO FROM TB_CONTA WHERE NR_CONTA = @nrContaDestino ) + @valorTransferencia);\r\n"
					+ "\r\n"
					+ "UPDATE TB_CONTA SET VL_SALDO = @novoSaldoDestino WHERE NR_CONTA = @nrContaDestino;";
			PreparedStatement statement = con.prepareStatement(sql.toUpperCase());
			statement.setInt(1, numeroConta);
			statement.setDouble(2, valor);
			statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Conta contaPorId(Long id) {
		Conta c = new Conta();
		
		try {
			
			Connection con = Conexao.abrir();
			

			PreparedStatement statement = con.prepareStatement("SELECT * FROM TB_CONTA WHERE NR_ID_CONTA = ?");
			statement.setLong(1, id);
			
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {
				
				c.setId(resultado.getInt("NR_ID_CONTA"));
				c.setAgencia(resultado.getInt("NR_AGENCIA"));
				c.setNumeroConta(resultado.getInt("NR_CONTA"));
				c.setSaldo(resultado.getDouble("VL_SALDO"));
				c.setSenha(resultado.getString("DS_SENHA"));
				
				
				
				
			}
			
			con.close();
			return c;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
	}

	@Override
	public Conta getCpf(String cpf) {
		Conta c = new Conta();
		try {
			Connection con = Conexao.abrir();
			String sql = "SET @cpfCliente = ?;\r\n"
					+ " \r\n"
					+ "SELECT * FROM TB_CONTA CO \r\n"
					+ "inner join TB_CLIENTE CL ON CO.NR_ID_CLIENTE = CL.NR_ID_CLIENTE\r\n"
					+ "WHERE \r\n"
					+ "CL.NR_CPF = @cpfCliente";
			PreparedStatement statement = con.prepareStatement(sql.toUpperCase());

			statement.setString(1, cpf);

			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {
				
				c.setId(resultado.getInt("NR_ID_CONTA"));
				c.setAgencia(resultado.getInt("NR_AGENCIA"));
				c.setNumeroConta(resultado.getInt("NR_CONTA"));
				c.setSaldo(resultado.getDouble("VL_SALDO"));
				c.setSenha(resultado.getString("DS_SENHA"));
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}

	@Override
	public void addConta(Conta conta) {
		try {
			Connection con = Conexao.abrir();
		String sql = "SET @cpfCliente = ?;\r\n"
				+ "\r\n"
				+ "SET @idUsuario = (SELECT NR_ID_CLIENTE FROM TB_CLIENTE WHERE NR_CPF = @cpfCliente);"
				+ "INSERT INTO TB_CONTA VALUES (?, ?, ?, ?, DEFAULT, @idUsuario);";
		PreparedStatement statement = con.prepareStatement(sql.toUpperCase());
		statement.setString(1, conta.getCpfDoCliente());
		statement.setString(2, conta.getSenha());
		statement.setDouble(3, conta.getSaldo());
		statement.setInt(4, conta.getNumeroConta());
		statement.setInt(5, conta.getAgencia());
		statement.execute();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean transferenciaPix(long idContaOrigem, String cpfDestino, double valor, TipoPagamento tipo) {
		try {
			Connection con = Conexao.abrir();
			String sql = "SET @cpfClienteDestino = ?;\r\n"
					+ " \r\n"
					+ "SET @tipoTransferencia = ?;\r\n"
					+ " \r\n"
					+ "SET @idCOntaOrigem = ?;\r\n"
					+ " \r\n"
					+ "SET @valorTransferencia = ?;\r\n"
					+ " \r\n"
					+ " \r\n"
					+ "SET @idContaDestino = (SELECT CO.NR_ID_CONTA FROM TB_CONTA CO INNER JOIN TB_CLIENTE CL ON CO.NR_ID_CLIENTE = CL.NR_ID_CLIENTE WHERE CL.NR_CPF = @cpfClienteDestino);\r\n"
					+ " \r\n"
					+ "INSERT INTO TB_TRANSFERENCIA VALUES(@idContaDestino, @idCOntaOrigem, @valorTransferencia, DEFAULT, @tipoTransferencia);\r\n"
					+ " \r\n"
					+ " \r\n"
					+ "SET @novoSaldoDestino = ((SELECT VL_SALDO FROM TB_CONTA WHERE NR_ID_CONTA = @idContaDestino ) + @valorTransferencia);\r\n"
					+ " \r\n"
					+ " \r\n"
					+ "SET @novoSaldoOrigem = ((SELECT VL_SALDO FROM TB_CONTA WHERE NR_ID_CONTA = @idCOntaOrigem) - @valorTransferencia);\r\n"
					+ " \r\n"
					+ " \r\n"
					+ "UPDATE TB_CONTA SET VL_SALDO = @novoSaldoDestino WHERE NR_ID_CONTA = @idContaDestino;\r\n"
					+ " \r\n"
					+ " \r\n"
					+ "UPDATE TB_CONTA SET VL_SALDO = @novoSaldoOrigem WHERE NR_ID_CONTA = @idCOntaOrigem";
			PreparedStatement statement = con.prepareStatement(sql.toUpperCase());
			statement.setInt(2, tipo.getTipoPagamento());
			statement.setLong(3, idContaOrigem);
			statement.setDouble(4, valor);
			statement.setString(1, cpfDestino);
			return statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean transferenciaTed(int agencia, int numeroConta, double valor, TipoPagamento tipo, long id) {
		try {
			Connection con = Conexao.abrir();
			String sql = "SET @nrContaDestino = ?;\r\n"
					+ " \r\n"
					+ "SET @nrAgenciaDestino = ?;\r\n"
					+ " \r\n"
					+ "SET @valorTransferencia = ?;\r\n"
					+ " \r\n"
					+ "SET @tipoTransferencia = ?;\r\n"
					+ " \r\n"
					+ "SET @idContaOrigem = ?;\r\n"
					+ " \r\n"
					+ " \r\n"
					+ "SET @idContaDestino = (SELECT NR_ID_CONTA FROM TB_CONTA WHERE NR_CONTA = @nrContaDestino AND NR_AGENCIA = @nrAgenciaDestino);\r\n"
					+ " \r\n"
					+ "INSERT INTO TB_TRANSFERENCIA VALUES(@idContaDestino, @idContaOrigem, @valorTransferencia, DEFAULT, @tipoTransferencia);\r\n"
					+ " \r\n"
					+ "SET @novoSaldoDestino = ((SELECT VL_SALDO FROM TB_CONTA WHERE NR_ID_CONTA = @idContaDestino ) + @valorTransferencia);\r\n"
					+ " \r\n"
					+ " \r\n"
					+ "SET @novoSaldoOrigem = ((SELECT VL_SALDO FROM TB_CONTA WHERE NR_ID_CONTA = @idCOntaOrigem) - @valorTransferencia);\r\n"
					+ " \r\n"
					+ " \r\n"
					+ "UPDATE TB_CONTA SET VL_SALDO = @novoSaldoDestino WHERE NR_ID_CONTA = @idContaDestino;\r\n"
					+ " \r\n"
					+ " \r\n"
					+ "UPDATE TB_CONTA SET VL_SALDO = @novoSaldoOrigem WHERE NR_ID_CONTA = @idCOntaOrigem";
			PreparedStatement statement = con.prepareStatement(sql.toUpperCase());
			statement.setInt(1, numeroConta);
			statement.setInt(2, agencia);
			statement.setDouble(3, valor);
			statement.setInt(4, tipo.getTipoPagamento());
			statement.setLong(5, id);
			return statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAgencia(int agencia) {
		try {
			Connection con = Conexao.abrir();
			String sql = "SELECT nr_id_conta FROM TB_CONTA WHERE nr_agencia = ?";
			PreparedStatement statement = con.prepareStatement(sql.toUpperCase());
			statement.setInt(1, agencia);
			return statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean getNumero(int numero) {
		try {
			Connection con = Conexao.abrir();
			String sql = "SELECT nr_id_conta FROM TB_CONTA WHERE nr_conta = ?";
			PreparedStatement statement = con.prepareStatement(sql.toUpperCase());
			statement.setInt(1, numero);
			return statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

