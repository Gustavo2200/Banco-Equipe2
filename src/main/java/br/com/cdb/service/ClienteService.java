package br.com.cdb.service;

import java.util.List;

import br.com.cdb.entity.Cliente;
import br.com.cdb.entity.TipoPagamento;

public interface ClienteService {
	public void addCliente(Cliente cliente);
	public Cliente login(String nome, String senha);
	public Cliente getIdCliente(long id);
	
}