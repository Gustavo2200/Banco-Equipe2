package br.com.cdb.dao;

import java.util.List;

import br.com.cdb.entity.Conta;
import br.com.cdb.enums.TipoPagamento;

public interface ContaDao {

	public List<Conta> listar();

	public Conta contaPorId(long id);

	public Conta getCpf(String cpf);

	public void addConta(Conta conta);

	public void transferenciaPix(long idContaOrigem, String cpfDestino, double valor, TipoPagamento tipo);

	public void transferenciaTed(long agencia, int numeroConta, double valor, TipoPagamento tipo);

}