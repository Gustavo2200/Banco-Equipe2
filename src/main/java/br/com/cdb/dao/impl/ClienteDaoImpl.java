package br.com.cdb.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.cdb.dao.ClienteDao;

import br.com.cdb.entity.Cliente;

public class ClienteDaoImpl implements ClienteDao {

	private List<Cliente> listaDeClientes = new ArrayList<>();
	public ClienteDaoImpl() {
	}
	public ClienteDaoImpl(List<Cliente> listadeclientes) {
		this.listaDeClientes = listadeclientes;
	}

	@Override
	public void addCliente(Cliente cliente) {
		cliente.setId(listaDeClientes.size());
		listaDeClientes.add(cliente);
	}

	@Override
	public Cliente getIdCliente(long id) {
		for (int i = 0; i < listaDeClientes.size(); i++) {
			Cliente clientes = listaDeClientes.get(i);
			if (listaDeClientes.get(i).getId() == id) {
				return clientes;
			}
		}
		return null;
	}

	@Override
	public Cliente login(String nome, String senha) {
		for (int i = 0; i < listaDeClientes.size(); i++) {
			Cliente clientes = listaDeClientes.get(i);
			if (nome.equalsIgnoreCase(listaDeClientes.get(i).getNome())) {
				return clientes;
			}
		}
		return null;

	}

	@Override
	public Cliente CpfExiste(String cpf) {
		for (int i = 0 ;i<listaDeClientes.size();i++) {
			Cliente cliente = listaDeClientes.get(i);
			if(cpf.equalsIgnoreCase(listaDeClientes.get(i).getCpf())){
				return cliente;
			}
		}
		return null;
	}
	
	public String formatoData(String dataNascimento)  {
		SimpleDateFormat dt= new SimpleDateFormat("dd/mm/yyyy");
		SimpleDateFormat dt2=new SimpleDateFormat("yyyy-mm-dd");
		try {
		Date dateN=dt.parse(dataNascimento);
		return dt2.format(dateN);
		}catch(Exception e) {
			throw new RuntimeException("Insira um formato valido");
		}
	}
	
	public String padraoBanco(String dataNascimento) {
		SimpleDateFormat padrao= new SimpleDateFormat("dd/mm/yyyy");
		return padrao.format(dataNascimento);
	}

}
