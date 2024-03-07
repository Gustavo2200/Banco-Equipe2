package br.com.cdb.dao.impl2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.cdb.dao.ContaDao;
import br.com.cdb.entity.Conta;
import br.com.cdb.enums.TipoPagamento;

public class ContaDaoImpl2 implements ContaDao {
	private List<Conta> lista= new ArrayList<>();

	@Override
	public void addConta(Conta conta) {
		conta.setId(lista.size());
		try {
			FileWriter file = new FileWriter(
					"Contas.txt",
					true);
			BufferedWriter writer = new BufferedWriter(file);
			writer.newLine();
			writer.write(conta.getCpfDoCliente() + "-" + conta.getSenha() + "-" + conta.getSaldo() + "-"
					+ conta.getNumeroConta() + "-" + conta.getAgencia() + "-" + conta.getId());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Conta> listar() {
		try {
			FileReader file = new FileReader(
					"Contas.txt");
			BufferedReader reader = new BufferedReader(file);
			while (reader.ready()) {
				String line = reader.readLine();
				String[] dados = line.split("-");
				Conta c = new Conta();
				c.setCpfDoCliente(dados[0]);
				c.setSenha(dados[1]);
				c.setSaldo(Double.parseDouble(dados[2]));
				c.setNumeroConta(Integer.parseInt(dados[3]));
				c.setAgencia(Integer.parseInt(dados[4]));
				c.setId(Integer.parseInt(dados[5]));
				reader.close();
				this.lista.add(c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this.lista;
	}

	@Override
	public Conta contaPorId(Long id) {
		for (Conta conta : listar()) {
			if (conta.getId() == id) {
				return conta;
			}
		}
		return null;
	}

	@Override
	public Conta getCpf(String cpf) {
		for (Conta conta : listar()) {
			if (conta.getCpfDoCliente().equals(cpf)) {
				return conta;
			}
		}
		return null;
	}

	@Override
	public void depositar(double valor, int numeroConta) {
		for (Conta c : listar()) {
			if (c.getNumeroConta() == numeroConta) {
				c.setSaldo(c.getSaldo() + valor);
				try {
					FileWriter file = new FileWriter(
							"Contas.txt",
							true);
					BufferedWriter writer = new BufferedWriter(file);
					writer.newLine();
					writer.write(c.getCpfDoCliente() + "-" + c.getSenha() + "-" + c.getSaldo() + "-"
							+ c.getNumeroConta() + "-" + c.getAgencia() + "-" + c.getId());
					writer.flush();
					writer.newLine();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}

	}

	@Override
	public boolean transferenciaPix(long idContaOrigem, String cpfDestino, double valor, TipoPagamento tipo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferenciaTed(long agencia, int numeroConta, double valor, TipoPagamento tipo, long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAgencia(int agencia) {
		for (Conta c : listar()) {
			if (c.getAgencia() == agencia) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getNumero(int numero) {
		for (Conta c : listar()) {
			if (c.getAgencia() == numero) {
				return true;
			}
		}
		return false;
	}

}
