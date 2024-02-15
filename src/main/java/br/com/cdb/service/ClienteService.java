package br.com.cdb.Service;

import java.util.List;

import br.com.cdb.entity.Cliente;

public interface ClienteService {
	public void addCliente(Cliente cliente);
	public Cliente login(String nome, String senha);
	public Cliente getIdCliente(long id);
	
}