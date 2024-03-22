package br.com.cdb.dao.impl4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cdb.dao.Conexao;
import br.com.cdb.dao.TransferenciaDao;
import br.com.cdb.entity.Transferencia;
import br.com.cdb.enums.TipoPagamento;

@Repository("TransferenciaDaoJDBC")
public class TransferenciaDaoImpl4 implements TransferenciaDao {

	List<Transferencia> transferencias = new ArrayList<Transferencia>();
	List<Transferencia> t = new ArrayList<Transferencia>();
	
	@Override
	public void salvar(Transferencia transferencia) {
		try {
		Connection conexao = Conexao.abrir();
		String sql = "insert into tb_transferencia(NR_CONTA_DESTINO, NR_CONTA_ORIGEM, VL_TRANSFERENCIA, NR_ID_TRANSFERENCIA, NR_TIPO)"
				+ " values (?, ?, ?, ?, ?)";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setLong(1, transferencia.getPessoa1());
		ps.setLong(2, transferencia.getPessoa2());
		ps.setDouble(3, transferencia.getValor());
		ps.setObject(4, transferencia.getTipo());
		transferencia.setId(transferencias.size());
		transferencias.add(transferencia);
		ps.execute();
		ps.close();
		conexao.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Transferencia> historico(int numero) {
		try {
		Connection con = Conexao.abrir();
		String sql = "Select * from tb_transferencia where NR_ID_Transferencia = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, numero);
		ResultSet rs = ps.executeQuery();
		Transferencia transf = new Transferencia();
		transf.setId(rs.getInt("NR_ID_TRANSFERENCIA"));
		transf.setPessoa1(rs.getInt("NR_CONTA_DESTINO"));
		transf.setPessoa2(rs.getInt("NR_CONTA_ORIGEM"));
		transf.setValor(rs.getInt("VL_TRANSFERENCIA"));
		transf.setTipo(TipoPagamento.values()[rs.getInt("NR_TIPO")]);
				
		t.add(transf);
		ps.close();
		con.close();
        
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return t;
		}
	
	
         

	@Override
	public List<Transferencia> transferencia() {
		try {
		Connection con = Conexao.abrir();
		String sql = "select * from tb_transferencia";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			Transferencia t = new Transferencia();
			t.setPessoa1(rs.getInt("NR_CONTA_DESTINO"));
			t.setPessoa2(rs.getInt("NR_CONTA_ORIGEM"));
			t.setValor(rs.getInt("VL_TRANSFERENCIA"));
			t.setTipo(TipoPagamento.values()[rs.getInt("NR_TIPO")]);
			t.setId(rs.getInt("NR_ID_TRANSFERENCIA"));
			transferencias.add(t);
		}
		con.close();

		
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return transferencias;
	}

	
}
