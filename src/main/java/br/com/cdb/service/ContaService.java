package br.com.cdb.service;

import java.util.List;

import br.com.cdb.entity.Conta;
import br.com.cdb.enums.TipoPagamento;

public interface ContaService {

	public Conta getCpf(String cpf);
	
	public int numeroAgencia();

	public int numerConta();
	
	public void depositar(double valor, int numeroConta);

	public double mostrarSaldo(long id);

	public void addConta(Conta conta);

	public void transferenciaPix(long idContaOrigem, String cpfDestino, double valor, TipoPagamento tipo);

	public void transferenciaTed(long agencia, int numeroConta, double valor, TipoPagamento tipo, long id);
	
	public List<Conta> listar();

	public boolean getAgencia(int agencia);
	
	public boolean getNumero(int numero);
	
	String validacaoSenha(String senha);
	
	public boolean valorPositivo(double valor);
	
	

}
