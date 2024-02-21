package br.com.cdb.dao.impl2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import br.com.cdb.dao.ContaDao;
import br.com.cdb.entity.Conta;
import br.com.cdb.enums.TipoConta;

public class ContaDaoImpl2 implements ContaDao {
	private List<Conta> lista;
	@Override
	public void addConta(Conta conta) {
		try {
			FileWriter file = new FileWriter(
					"C:\\Users\\ebabetto\\Documents\\Projetos\\BancoDigital\\Banco-Equipe2\\src\\main\\java\\br\\com\\cdb\\dao\\impl2\\Contas.txt",
					true);
			BufferedWriter writer = new BufferedWriter(file);
			writer.newLine();
			writer.write(conta.getCpfDoCliente() + "-" + conta.getSenha() + "-" + conta.getSaldo() + "-"
					+ conta.getNumeroConta() + "-" + conta.getAgencia() + "-" + conta.getId() + "-"
					+ conta.getTipoConta());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Conta> listar() {
		try {
			FileReader file = new FileReader("C:\\Users\\ebabetto\\Documents\\Projetos\\BancoDigital\\Banco-Equipe2\\src\\main\\java\\br\\com\\cdb\\dao\\impl2\\Contas.txt");
			BufferedReader reader = new BufferedReader(file);
			while(reader.ready()) {
				String line = reader.readLine();
				String[] dados = line.split("-");
				Conta c = new Conta();
				c.setCpfDoCliente(dados[0]);
				c.setSenha(dados[1]);
				c.setSaldo(Double.parseDouble(dados[2]));
				c.setNumeroConta(Integer.parseInt(dados[3]));
				c.setAgencia(Integer.parseInt(dados[4]));
				c.setId(Integer.parseInt(dados[5]));
				if(dados[6].equals("0")) {
				c.setTipoConta(TipoConta.CONTA_CORRENTE);
				}
				else {
					c.setTipoConta(TipoConta.CONTA_POUPANCA);
				}
				this.lista.add(c);
				}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return this.lista;
	}

	@Override
	public Conta contaPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conta getCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

}
