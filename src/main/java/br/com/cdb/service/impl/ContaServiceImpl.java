package br.com.cdb.service.impl;

import br.com.cdb.service.ContaService;
import br.com.cdb.dao.ContaDao;
import br.com.cdb.entity.Conta;
import br.com.cdb.entity.Transferencia;

import java.util.Random;

public class ContaServiceImpl implements ContaService {
	ContaDao contaDao;
	Random random = new Random();
	@Override
	public int numeroAgencia() {
		Random random = new Random();
		int numeroAle = random.nextInt(9000) + 1000;
		
		return numeroAle;
	}

	@Override
	public void numerConta(Conta conta) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void registrarPix(long idContaOrigem, String cpfDestino, double valor) {
		Conta contaOrigem=contaDao.contaPorId(idContaOrigem);
		Conta contaDestino=null;
		if(contaOrigem!=null) {
			 contaDestino=contaDao.getCpf(cpfDestino);
		}
		
	if(contaDestino!=null) {
		Transferencia transf= new Transferencia(contaOrigem.getNumeroConta(),contaDestino.getNumeroConta(),valor);
	
		transf.transferir(contaOrigem, contaDestino);
	
	}else {
		throw new RuntimeException("Conta destino não encontrada");
	}
	
	
	}
	}
