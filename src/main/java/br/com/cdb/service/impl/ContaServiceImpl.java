package br.com.cdb.service.impl;

import br.com.cdb.service.ContaService;
import br.com.cdb.dao.ContaDao;
import br.com.cdb.entity.Conta;

import br.com.cdb.enums.TipoPagamento;

import java.util.Random;

public class ContaServiceImpl implements ContaService {
	ContaDao contaDao;
	Random random = new Random();

	public ContaServiceImpl(ContaDao contaDao) {
		this.contaDao = contaDao;
	}
	
	
	@Override
	public int numeroAgencia() {
		Random random = new Random();
		int numeroAle = random.nextInt(9000) + 1000;

		return numeroAle;
	}

	@Override
	public int numerConta() {
		Random random = new Random();
		int numeroAlea = random.nextInt(9000) + 1000;

		return numeroAlea;
	}

	@Override
	public void transferenciaPix(long idContaOrigem, String cpfDestino, double valor, TipoPagamento tipo) {
		contaDao.transferenciaPix(idContaOrigem, cpfDestino, valor, tipo);

	}
	
	@Override
	public double mostrarSaldo(long id) {
		return contaDao.contaPorId(id).getSaldo();
	}

	

	@Override
	public void transferenciaTed(long agencia, int numeroConta, double valor, TipoPagamento tipo) {
		contaDao.transferenciaTed(agencia, numeroConta, valor, tipo);

	}

	@Override
	public void addConta(Conta conta) {
	contaDao.addConta(conta);
	}

}
