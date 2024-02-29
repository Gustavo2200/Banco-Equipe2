package br.com.cdb.service;

import br.com.cdb.entity.Cliente;

public interface ClienteService {
	public void addCliente(Cliente cliente);

	public Cliente login(String nome, String senha);

	public Cliente getIdCliente(long id);

	String validacaoCpf(String cpf);

	String validacaoNome(String nome);

	String validacaoData(String data);

	String validacaoEmail(String email);

	String validacaoSenha(String senha);

}