package br.com.cdb.service;

import br.com.cdb.entity.Conta;
import br.com.cdb.enums.TipoPagamento;

public interface ContaService {

	public int numeroAgencia();

	public int numerConta();

	public double mostrarSaldo(long id);

	public void addConta(Conta conta);

	public void transferenciaPix(long idContaOrigem, String cpfDestino, double valor, TipoPagamento tipo);

	public void transferenciaTed(long agencia, int numeroConta, double valor, TipoPagamento tipo);

}
