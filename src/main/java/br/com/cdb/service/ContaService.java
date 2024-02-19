package br.com.cdb.service;

import br.com.cdb.entity.Conta;

public interface ContaService {

	public int numeroAgencia();

	public void numerConta(Conta conta);
	
	public void registrarPix(long idContaOrigem, String cpfDestino, double valor);
}
