package br.com.cdb.dao;

import java.util.List;

import br.com.cdb.entity.Cliente;

public interface ClienteDao {


	public void addCliente(Cliente cliente);
	public Cliente getIdCliente(long id);
	public Cliente login(String nome, String senha);
	public Cliente CpfExiste(String cpf);
}
