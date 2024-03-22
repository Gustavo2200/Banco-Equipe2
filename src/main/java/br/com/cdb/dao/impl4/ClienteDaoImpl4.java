package br.com.cdb.dao.impl4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import br.com.cdb.dao.ClienteDao;
import br.com.cdb.dao.Conexao;
import br.com.cdb.entity.Cliente;

@Repository("ClienteDaoJdbc")
public class ClienteDaoImpl4 implements ClienteDao {
	

	@Override
	public void addCliente(Cliente cliente) {
		try {
			Connection con = Conexao.abrir();
			String sql = "insert into tb_cliente (nm_cliente, dt_nascimento, nr_cpf, ds_email, ds_senha) values (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getDataNascimento());
			ps.setString(3, cliente.getCpf());
			ps.setString(4, cliente.getEmail());
			ps.setString(5, cliente.getSenha());
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cliente getIdCliente(long id) {
		Cliente cliente = null;
		try {
			Connection con = Conexao.abrir();
			String sql = "select * from tb_cliente where nr_id_cliente = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("nr_id_cliente"));
				cliente.setNome(rs.getString("nm_cliente"));
				cliente.setDataNascimento(rs.getString("dt_nascimento"));
				cliente.setCpf(rs.getString("nr_cpf"));
				cliente.setEmail(rs.getString("ds_email"));
				cliente.setSenha(rs.getString("ds_senha"));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public Cliente login(String nome, String senha) {
		Cliente cliente = null;
		try {
			Connection con = Conexao.abrir();
			String sql = "select * from tb_cliente where nm_cliente = ? and ds_senha = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("nr_id_cliente"));
				cliente.setNome(rs.getString("nm_cliente"));
				cliente.setDataNascimento(rs.getString("dt_nascimento"));
				cliente.setCpf(rs.getString("nr_cpf"));
				cliente.setEmail(rs.getString("ds_email"));
				cliente.setSenha(rs.getString("ds_senha"));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public Cliente CpfExiste(String cpf) {
		Cliente cliente = null;
		try {
			Connection con = Conexao.abrir();
			String sql = "select * from tb_cliente where nr_cpf = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("nr_id_cliente"));
				cliente.setNome(rs.getString("nm_cliente"));
				cliente.setDataNascimento(rs.getString("dt_nascimento"));
				cliente.setCpf(rs.getString("nr_cpf"));
				cliente.setEmail(rs.getString("ds_email"));
				cliente.setSenha(rs.getString("ds_senha"));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
}