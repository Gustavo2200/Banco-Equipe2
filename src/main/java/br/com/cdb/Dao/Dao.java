package br.com.cdb.Dao;

import java.util.List;

import br.com.cdb.entity.Cliente;

public interface Dao {


	public void addCliente(Cliente cliente);
	public Cliente getIdCliente(long id);
	public Cliente login(String nome, String senha);
}
