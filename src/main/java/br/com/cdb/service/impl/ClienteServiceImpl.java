package br.com.cdb.service.impl;


import br.com.cdb.dao.ClienteDao;
import br.com.cdb.entity.Cliente;
import br.com.cdb.service.ClienteService;


public class ClienteServiceImpl implements ClienteService {
	private ClienteDao clienteDao;
	public ClienteServiceImpl(ClienteDao cd) {
		this.clienteDao = cd;
	}
	
	@Override
	public void addCliente(Cliente cliente) {
		Cliente c = clienteDao.CpfExiste(cliente.getCpf());
		if(c==null) {
			if(cliente.getCpf().length()==11)
			clienteDao.addCliente(cliente);
		}
		else {
			throw new RuntimeException("Cpf já cadastrado");
		}
	}

	@Override
	public Cliente login(String nome, String senha) {
		Cliente cliente = clienteDao.login(nome, senha);
		if(cliente != null) {
			if(senha.equals(cliente.getSenha())){
				return cliente;
			}
			else {
				throw new RuntimeException("Senha inválida");
			}
		}
		else {
			throw new RuntimeException("Usuário inválida");
		}
	}

	@Override
	public Cliente getIdCliente(long id) {
		return clienteDao.getIdCliente(id);
	}


}
