package br.com.cdb.service.impl;

import br.com.cdb.service.ContaService;
import br.com.cdb.dao.ContaDao;
import br.com.cdb.entity.Conta;
<<<<<<< HEAD
import br.com.cdb.entity.Transferencia;
=======

>>>>>>> feature/feature4
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
<<<<<<< HEAD
	public void registrarPix(long idContaOrigem, String cpfDestino, double valor,TipoPagamento tipo) {
		Conta contaOrigem=contaDao.contaPorId(idContaOrigem);
		Conta contaDestino=null;
		if(contaOrigem!=null) {
			 contaDestino=contaDao.getCpf(cpfDestino);
		}
		
	if(contaDestino!=null) {
		Transferencia transf= new Transferencia(contaOrigem.getNumeroConta(),contaDestino.getNumeroConta(),valor,tipo);
	
		transf.transferir(contaOrigem, contaDestino);
	
	}else {
		throw new RuntimeException("Conta destino não encontrada");
=======
	public void transferenciaPix(long idContaOrigem, String cpfDestino, double valor, TipoPagamento tipo) {
		contaDao.transferenciaPix(idContaOrigem, cpfDestino, valor, tipo);

>>>>>>> feature/feature4
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
