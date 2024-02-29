package br.com.cdb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.cdb.dao.ContaDao;
import br.com.cdb.entity.Conta;
import br.com.cdb.entity.Transferencia;
import br.com.cdb.enums.TipoPagamento;

public class ContaDaoImpl implements ContaDao {
	private ArrayList<Conta> listaDeContas = new ArrayList<>();

	@Override
	public void addConta(Conta conta) {
		conta.setId(listaDeContas.size());
		listaDeContas.add(conta);

	}

	@Override
	public List<Conta> listar() {

		return listaDeContas;

	}

	@Override
	public Conta contaPorId(long id) {

		for (Conta conta : listaDeContas) {
			if (conta.getId() == id) {
				return conta;
			}

		}
		return null;
	}

	@Override
	public Conta getCpf(String cpf) {
		for (int i = 0; i < listaDeContas.size(); i++) {
			if (listaDeContas.get(i).getCpfDoCliente().equals(cpf)) {
				return listaDeContas.get(i);
			}
		}
		return null;
	}

	@Override
	public void transferenciaTed(long agencia, int numeroConta, double valor, TipoPagamento tipo, long id) {

		Conta contaD = new Conta();
		Conta contaO = new Conta();

		for (Conta conta : listaDeContas) {
			if (conta.getId() == id) {
				contaO = conta;
			}
			if (conta.getNumeroConta() == numeroConta && conta.getAgencia()== agencia) {
				contaD = conta;
			}

		}
		Transferencia trans = new Transferencia(contaO.getNumeroConta(), contaD.getNumeroConta(), valor, tipo);
		trans.transferir(contaO, contaD, valor);

		listaDeContas.add(contaO);
		listaDeContas.add(contaD);

	}

	@Override
	public void transferenciaPix(long idContaOrigem, String cpfDestino, double valor, TipoPagamento tipo) {
		Conta contaOrigem = contaPorId(idContaOrigem);
		Conta contaDestino = null;
		if (contaOrigem != null) {
			contaDestino = getCpf(cpfDestino);
		}

		if (contaDestino != null) {
			Transferencia transf = new Transferencia(contaOrigem.getNumeroConta(), contaDestino.getNumeroConta(),
					valor, tipo);

			transf.transferir(contaOrigem, contaDestino, valor);

		} else {
			throw new RuntimeException("Conta destino não encontrada");
		}
		
		listaDeContas.add(contaDestino);
		listaDeContas.add(contaOrigem);
	}

	@Override
	public void depositar(double valor, int numeroConta) {
		Conta conta3 = null;
		for (Conta conta : listaDeContas) {
			if (numeroConta == conta.getNumeroConta()) {
				conta.setSaldo(valor + conta.getSaldo());
				conta3 = conta;
				break;  
	        }
	    }

	    if (conta3 != null) {
	        
	        listaDeContas.remove(conta3);
	        listaDeContas.add(conta3);
	    } else {
	     
	        throw new RuntimeException("Conta não encontrada");
	    }
	}

	@Override
	public boolean getSenha(String senha) {
		for(Conta conta:listaDeContas) {
			if(senha.equals(conta.getSenha())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getAgencia(int agencia) {
		for(Conta conta:listaDeContas) {
			if(agencia ==conta.getAgencia()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getNumero(int numero) {
		for(Conta conta:listaDeContas) {
			if(numero==conta.getNumeroConta()) {
				return true;
			}
		}
		return false;
	}
}
