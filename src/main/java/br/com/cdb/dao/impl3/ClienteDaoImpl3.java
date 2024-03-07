package br.com.cdb.dao.impl3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cdb.dao.ClienteDao;
import br.com.cdb.dao.repository.ClienteRepository;
import br.com.cdb.entity.Cliente;

public class ClienteDaoImpl3 implements ClienteDao {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public void addCliente(Cliente cliente) {
		clienteRepository.save(cliente);

	}

	@Override
	public Cliente getIdCliente(long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public Cliente login(String nome, String senha) {
		List<Cliente> clientes = clienteRepository.findAll();
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equals(nome) && cliente.getSenha().equals(senha)) {
				return cliente;
			}
		}
		return null;
	}

	@Override
	public Cliente CpfExiste(String cpf) {
		List<Cliente> clientes = clienteRepository.findAll();
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}
}