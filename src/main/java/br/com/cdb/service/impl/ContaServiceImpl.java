package br.com.cdb.service.impl;

import br.com.cdb.service.ContaService;
import br.com.cdb.entity.Conta;

import java.util.Random;

public class ContaServiceImpl implements ContaService {
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
		
	}}
