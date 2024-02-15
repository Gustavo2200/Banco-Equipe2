package br.com.cdb.Dao;

import java.util.List;

import br.com.cdb.entity.Conta;

public interface ContaDao {

	public void addConta(Conta conta);
	
	public List<Conta> listar();
	
	public Conta contaPorId(long id);
	
	void getCpf(String cpf);
}