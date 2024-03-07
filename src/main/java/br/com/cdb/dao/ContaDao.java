package br.com.cdb.dao;

import java.util.List;

import br.com.cdb.entity.Conta;
import br.com.cdb.enums.TipoPagamento;

public interface ContaDao {

	public List<Conta> listar();
	
	public void depositar(double valor, int numeroConta);

	public Conta contaPorId(Long id);

	public Conta getCpf(String cpf);

	public void addConta(Conta conta);

	public boolean transferenciaPix(long idContaOrigem, String cpfDestino, double valor, TipoPagamento tipo);

	public boolean transferenciaTed(int agencia, int numeroConta, double valor, TipoPagamento tipo, long id);
	
	public boolean getAgencia(int agencia);
	
	public boolean getNumero(int numero);

}